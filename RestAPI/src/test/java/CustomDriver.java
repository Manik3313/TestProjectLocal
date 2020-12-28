import io.testproject.sdk.drivers.ReportingDriver;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.drivers.web.RemoteWebDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import io.testproject.sdk.internal.helpers.DriverShutdownThread;
import io.testproject.sdk.internal.reporting.Reporter;
import io.testproject.sdk.internal.rest.AgentClient;
import io.testproject.sdk.internal.rest.ReportSettings;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class CustomDriver extends RemoteWebDriver implements ReportingDriver
{
    private final DriverShutdownThread driverShutdownThread;

    /**
     * Steps reporter instance.
     */
    private Reporter reporter = null;

    public CustomDriver(final URL remoteAddress,
                 final String token,
                 final ChromeOptions options)
            throws InvalidTokenException, AgentConnectException, IOException,
            ObsoleteVersionException {
        this(remoteAddress, token, options, null, null, false);
    }
    public CustomDriver(final URL remoteAddress,
                 final String token,
                 final ChromeOptions options,
                 final String projectName,
                 final String jobName,
                 final boolean disableReports)
            throws InvalidTokenException, AgentConnectException, IOException,
            ObsoleteVersionException {
        super(new ChromeOptions().merge(AgentClient
                .getClient(remoteAddress, token, options,
                        new ReportSettings(projectName, jobName), disableReports)
                .getSession().getCapabilities()));

        this.reporter = new Reporter(this, AgentClient.getClient(this.getCapabilities()));
        this.getReportingCommandExecutor().setReportsDisabled(disableReports);

        this.driverShutdownThread = new DriverShutdownThread(this);
        Runtime.getRuntime().addShutdownHook(this.driverShutdownThread);
    }


    public CustomDriver()
            throws InvalidTokenException, AgentConnectException, IOException,
            ObsoleteVersionException {
        this(null, null, new ChromeOptions());
    }

    static class FakeDriverService extends ChromeDriverService {

        /**
         * Initiates a new DriverService with dummy data.
         *
         * @throws IOException If an I/O error occurs.
         */
        FakeDriverService() throws IOException {
            super(new File(""), 0, null, null);
        }
    }

}
