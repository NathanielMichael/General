package net.craftstars.general.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for logging pretty messages.
 * <p>
 * Must be initialized before use. See initialize method.
 * 
 * @author Plutonium239
 */
public enum Log
{
    /**
     * The instance of this class.
     */
    INSTANCE;
    
    private Logger logger;
    private String pluginName;
    private Boolean debug;
    
    /**
     * Returns the instance of this class.
     * 
     * @return Log the instance of this class
     */
    public static Log getInstance()
    {
        return INSTANCE;
    }
    
    /**
     * Initializes this class. Must be done before use.
     * 
     * @param logger     the logger we will be logging to
     * @param pluginName the name of the plugin managing this instance
     * @param debugMode  the debug mode of plugin managing this instance
     */
    public static void initialize(Logger logger, String pluginName, Boolean debugMode)
    {
        getInstance().logger = logger;
        getInstance().pluginName = pluginName;
        getInstance().debug = debugMode;
    }
    
    private Logger getLogger()
    {
        if (this.logger == null)
        {
            throw new IllegalStateException();
        }
        
        return this.logger;
    }
    
    private String getPluginName()
    {
        if (this.pluginName == null)
        {
            throw new IllegalStateException();
        }
        
        return this.pluginName;
    }
    
    private Boolean getDebug()
    {
        if (this.debug == null)
        {
            throw new IllegalStateException();
        }
        
        return this.debug;
    }
    
    private void log(Level level, String msg)
    {
        this.getLogger().log(level, this.formatLogMessage(msg));
    }
    
    private void log(Level level, String msg, Throwable thrown)
    {
        this.getLogger().log(level, this.formatLogMessage(msg), thrown);
    }
    
    private String formatLogMessage(String msg)
    {
        return "["+this.getPluginName()+"] "+msg;
    }
    
    /**
     * Logs an info message with exception.
     * 
     * @param msg    the message to log
     * @param thrown the exception thrown
     */
    public static void info(String msg, Throwable thrown)
    {
        getInstance().log(Level.INFO, msg, thrown);
    }
    
    /**
     * Logs an info message.
     * 
     * @param msg    the message to log
     */
    public static void info(String msg)
    {
        getInstance().log(Level.INFO, msg);
    }
    
    /**
     * Logs a warning message with exception.
     * 
     * @param msg    the message to log
     * @param thrown the exception thrown
     */
    public static void warn(String msg, Throwable thrown)
    {
        getInstance().log(Level.WARNING, msg, thrown);
    }
    
    /**
     * Logs a warning message.
     * 
     * @param msg    the message to log
     */
    public static void warn(String msg)
    {
        getInstance().log(Level.WARNING, msg);
    }
    
    /**
     * Logs an error message with exception.
     * 
     * @param msg    the message to log
     * @param thrown the exception thrown
     */
    public static void error(String msg, Throwable thrown)
    {
        getInstance().log(Level.SEVERE, msg, thrown);
    }
    
    /**
     * Logs an error message.
     * 
     * @param msg    the message to log
     */
    public static void error(String msg)
    {
        getInstance().log(Level.SEVERE, msg);
    }
    
    /**
     * Logs a debug message with exception.
     * 
     * @param msg    the message to log
     * @param thrown the exception thrown
     */
    public static void debug(String msg, Throwable thrown)
    {
        if (getInstance().getDebug()) getInstance().log(Level.INFO, msg, thrown);
    }
    
    /**
     * Logs a debug message.
     * 
     * @param msg    the message to log
     */
    public static void debug(String msg)
    {
        if (getInstance().getDebug()) getInstance().log(Level.INFO, msg);
    }
}