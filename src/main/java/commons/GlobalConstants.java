package commons;

import java.io.File;

public class GlobalConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    public static final String USER_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";

    public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFile";

    public static final String U_BLOCK_EXTENSION_OF_CHROME = PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "Ublock_Chrome.crx";
    public static final String AD_BLOCK_EXTENSION_OF_FIREFOX = PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "adblocker-firefox.xpi";

    public static final int LONG_TIME_OUT = 30;
    public static final int SHORT_TIME_OUT = 10;
}
