package sa.miu.RTDIS.logging;

public interface ILogger {
    public void error (String error);
    public void debug (String debug);

    public void info(String info);

    public void warning (String warning);
}
