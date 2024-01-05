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

import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

/**
 * TimberAndroidLoggerFactory is an implementation of [ILoggerFactory] returning
 * the appropriately named [TimberAndroidLoggerFactory] instance.
 *
 * @author Patrick Favre-Bulle <patrick.favrebulle></patrick.favrebulle>@gmail.com>
 */
internal class TimberAndroidLoggerFactory : ILoggerFactory {
    private val loggerMap: ConcurrentMap<String, Logger> = ConcurrentHashMap()

    /**
     * Return an appropriate [TimberAndroidLoggerAdapter] instance by name.
     */
    override fun getLogger(name: String?): Logger {
        val tag = name ?: ANONYMOUS_TAG
        var logger = loggerMap[tag]
        if (logger == null) {
            val newInstance: Logger = TimberAndroidLoggerAdapter(tag)
            val oldInstance = loggerMap.putIfAbsent(tag, newInstance)
            logger = oldInstance ?: newInstance
        }
        return logger
    }

    private companion object {

        private const val ANONYMOUS_TAG = "null"
    }
}
