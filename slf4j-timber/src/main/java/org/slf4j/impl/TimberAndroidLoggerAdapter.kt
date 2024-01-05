/*
 * Copyright (c) 2004-2013 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.slf4j.impl

import android.util.Log
import org.slf4j.helpers.MarkerIgnoringBase
import org.slf4j.helpers.MessageFormatter
import timber.log.Timber

/**
 *
 * A simple implementation that delegates all log requests to the Jake Wharton's Timber
 * logging facilities. Note that this logger does not support [org.slf4j.Marker].
 * Methods taking marker data as parameter simply invoke the eponymous method
 * without the Marker argument, discarding any marker data in the process.
 *
 *
 *
 * The logging levels specified for SLF4J can be almost directly mapped to
 * the levels that exist in Timber platform. The following table
 * shows the mapping implemented by this logger.
 *
 *
 * <table border="1">
 * <tr><th>**SLF4J******</th><th>**Android**</th></tr>
 * <tr><td>TRACE</td><td>[android.util.Log.VERBOSE]</td></tr>
 * <tr><td>DEBUG</td><td>[android.util.Log.DEBUG]</td></tr>
 * <tr><td>INFO</td><td>[android.util.Log.INFO]</td></tr>
 * <tr><td>WARN</td><td>[android.util.Log.WARN]</td></tr>
 * <tr><td>ERROR</td><td>[android.util.Log.ERROR]</td></tr>
</table> *
 *
 *
 *
 * Use loggers as usual:
 *
 *  *
 * Declare a logger<br></br>
 * `private static final Logger logger = LoggerFactory.getLogger(MyClass.class);`
 *
 *  *
 * Invoke logging methods, e.g.,<br></br>
 * `logger.debug("Some log message. Details: {}", someObject);`<br></br>
 * `logger.debug("Some log message with varargs. Details: {}, {}, {}", someObject1, someObject2, someObject3);`
 *
 *
 *
 *
 *
 *
 * Logger instances created using the LoggerFactory are named either according to the name
 * or the fully qualified class name of the class given as a parameter.
 * Each logger name will be used as the log message tag on the Android platform. No truncating
 * will take place since Timber handles this itself.
 *
 *
 * @author Andrey Korzhevskiy <a.korzhevskiy></a.korzhevskiy>@gmail.com>
 * @author Patrick Favre-Bulle <patrick.favrebulle></patrick.favrebulle>@gmail.com>
 */
internal class TimberAndroidLoggerAdapter(tag: String?) : MarkerIgnoringBase() {
    /**
     * Package access allows only [TimberAndroidLoggerFactory] to instantiate
     * SimpleLogger instances.
     */
    init {
        name = tag
    }

    /**
     * Is this logger instance enabled for the VERBOSE level?
     *
     * @return True if this Logger is enabled for level VERBOSE, false otherwise.
     */
    override fun isTraceEnabled(): Boolean {
        return isLoggable(Log.VERBOSE)
    }

    /**
     * Log a message object at level VERBOSE.
     *
     * @param msg - the message object to be logged
     */
    override fun trace(msg: String) {
        log(Log.VERBOSE, msg, null)
    }

    /**
     * Log a message at level VERBOSE according to the specified format and
     * argument.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for level VERBOSE.
     *
     *
     * @param format the format string
     * @param arg    the argument
     */
    override fun trace(format: String, arg: Any) {
        formatAndLog(Log.VERBOSE, format, arg)
    }

    /**
     * Log a message at level VERBOSE according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the VERBOSE level.
     *
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    override fun trace(format: String, arg1: Any, arg2: Any) {
        formatAndLog(Log.VERBOSE, format, arg1, arg2)
    }

    /**
     * Log a message at level VERBOSE according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the VERBOSE level.
     *
     *
     * @param format   the format string
     * @param argArray an array of arguments
     */
    override fun trace(format: String, vararg argArray: Any) {
        formatAndLog(Log.VERBOSE, format, *argArray)
    }

    /**
     * Log an exception (throwable) at level VERBOSE with an accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    override fun trace(msg: String, t: Throwable) {
        log(Log.VERBOSE, msg, t)
    }

    /**
     * Is this logger instance enabled for the DEBUG level?
     *
     * @return True if this Logger is enabled for level DEBUG, false otherwise.
     */
    override fun isDebugEnabled(): Boolean {
        return isLoggable(Log.DEBUG)
    }

    /**
     * Log a message object at level DEBUG.
     *
     * @param msg - the message object to be logged
     */
    override fun debug(msg: String) {
        log(Log.DEBUG, msg, null)
    }

    /**
     * Log a message at level DEBUG according to the specified format and argument.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for level DEBUG.
     *
     *
     * @param format the format string
     * @param arg    the argument
     */
    override fun debug(format: String, arg: Any) {
        formatAndLog(Log.DEBUG, format, arg)
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the DEBUG level.
     *
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    override fun debug(format: String, arg1: Any, arg2: Any) {
        formatAndLog(Log.DEBUG, format, arg1, arg2)
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the DEBUG level.
     *
     *
     * @param format   the format string
     * @param argArray an array of arguments
     */
    override fun debug(format: String, vararg argArray: Any) {
        formatAndLog(Log.DEBUG, format, *argArray)
    }

    /**
     * Log an exception (throwable) at level DEBUG with an accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    override fun debug(msg: String, t: Throwable) {
        log(Log.DEBUG, msg, t)
    }

    /**
     * Is this logger instance enabled for the INFO level?
     *
     * @return True if this Logger is enabled for the INFO level, false otherwise.
     */
    override fun isInfoEnabled(): Boolean {
        return isLoggable(Log.INFO)
    }

    /**
     * Log a message object at the INFO level.
     *
     * @param msg - the message object to be logged
     */
    override fun info(msg: String) {
        log(Log.INFO, msg, null)
    }

    /**
     * Log a message at level INFO according to the specified format and argument.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     *
     *
     * @param format the format string
     * @param arg    the argument
     */
    override fun info(format: String, arg: Any) {
        formatAndLog(Log.INFO, format, arg)
    }

    /**
     * Log a message at the INFO level according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     *
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    override fun info(format: String, arg1: Any, arg2: Any) {
        formatAndLog(Log.INFO, format, arg1, arg2)
    }

    /**
     * Log a message at level INFO according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     *
     *
     * @param format   the format string
     * @param argArray an array of arguments
     */
    override fun info(format: String, vararg argArray: Any) {
        formatAndLog(Log.INFO, format, *argArray)
    }

    /**
     * Log an exception (throwable) at the INFO level with an accompanying
     * message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    override fun info(msg: String, t: Throwable) {
        log(Log.INFO, msg, t)
    }

    /**
     * Is this logger instance enabled for the WARN level?
     *
     * @return True if this Logger is enabled for the WARN level, false
     * otherwise.
     */
    override fun isWarnEnabled(): Boolean {
        return isLoggable(Log.WARN)
    }

    /**
     * Log a message object at the WARN level.
     *
     * @param msg - the message object to be logged
     */
    override fun warn(msg: String) {
        log(Log.WARN, msg, null)
    }

    /**
     * Log a message at the WARN level according to the specified format and
     * argument.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     *
     *
     * @param format the format string
     * @param arg    the argument
     */
    override fun warn(format: String, arg: Any) {
        formatAndLog(Log.WARN, format, arg)
    }

    /**
     * Log a message at the WARN level according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     *
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    override fun warn(format: String, arg1: Any, arg2: Any) {
        formatAndLog(Log.WARN, format, arg1, arg2)
    }

    /**
     * Log a message at level WARN according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     *
     *
     * @param format   the format string
     * @param argArray an array of arguments
     */
    override fun warn(format: String, vararg argArray: Any) {
        formatAndLog(Log.WARN, format, *argArray)
    }

    /**
     * Log an exception (throwable) at the WARN level with an accompanying
     * message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    override fun warn(msg: String, t: Throwable) {
        log(Log.WARN, msg, t)
    }

    /**
     * Is this logger instance enabled for level ERROR?
     *
     * @return True if this Logger is enabled for level ERROR, false otherwise.
     */
    override fun isErrorEnabled(): Boolean {
        return isLoggable(Log.ERROR)
    }

    /**
     * Log a message object at the ERROR level.
     *
     * @param msg - the message object to be logged
     */
    override fun error(msg: String) {
        log(Log.ERROR, msg, null)
    }

    /**
     * Log a message at the ERROR level according to the specified format and
     * argument.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     *
     *
     * @param format the format string
     * @param arg    the argument
     */
    override fun error(format: String, arg: Any) {
        formatAndLog(Log.ERROR, format, arg)
    }

    /**
     * Log a message at the ERROR level according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     *
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    override fun error(format: String, arg1: Any, arg2: Any) {
        formatAndLog(Log.ERROR, format, arg1, arg2)
    }

    /**
     * Log a message at level ERROR according to the specified format and
     * arguments.
     *
     *
     *
     *
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     *
     *
     * @param format   the format string
     * @param argArray an array of arguments
     */
    override fun error(format: String, vararg argArray: Any) {
        formatAndLog(Log.ERROR, format, *argArray)
    }

    /**
     * Log an exception (throwable) at the ERROR level with an accompanying
     * message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    override fun error(msg: String, t: Throwable) {
        log(Log.ERROR, msg, t)
    }

    private fun formatAndLog(priority: Int, format: String, vararg argArray: Any) {
        if (isLoggable(priority)) {
            val ft = MessageFormatter.arrayFormat(format, argArray)
            logInternal(priority, ft.message, ft.throwable)
        }
    }

    private fun log(priority: Int, message: String, throwable: Throwable?) {
        if (isLoggable(priority)) {
            logInternal(priority, message, throwable)
        }
    }

    /**
     * Currently all levels are enabled, since Timber will decide if the log will be actually used
     *
     * @return always true
     */
    private fun isLoggable(priority: Int): Boolean {
        return Timber.treeCount > 0
    }

    private fun logInternal(priority: Int, message: String?, throwable: Throwable?) {
        Timber.tag(name)
        if (throwable != null) {
            if (message != null) {
                Timber.log(priority, throwable, message)
            } else {
                Timber.log(priority, throwable)
            }
        } else {
            Timber.log(priority, message)
        }
    }
}
