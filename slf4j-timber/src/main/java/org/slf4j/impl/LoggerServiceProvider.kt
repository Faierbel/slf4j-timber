package org.slf4j.impl

import org.slf4j.ILoggerFactory
import org.slf4j.IMarkerFactory
import org.slf4j.helpers.BasicMDCAdapter
import org.slf4j.helpers.BasicMarkerFactory
import org.slf4j.spi.MDCAdapter
import org.slf4j.spi.SLF4JServiceProvider

class LoggerServiceProvider : SLF4JServiceProvider {

    private var loggerFactory: ILoggerFactory? = null
    private var markerFactory: IMarkerFactory? = null
    private var mdcAdapter: MDCAdapter? = null

    override fun getLoggerFactory(): ILoggerFactory {
        return loggerFactory!!
    }

    override fun getMarkerFactory(): IMarkerFactory {
        return markerFactory!!
    }

    override fun getMDCAdapter(): MDCAdapter {
        return mdcAdapter!!
    }

    override fun getRequestedApiVersion(): String {
        return REQUESTED_API_VERSION
    }

    override fun initialize() {
        loggerFactory = TimberAndroidLoggerFactory()
        markerFactory = BasicMarkerFactory()
        mdcAdapter = BasicMDCAdapter()
    }

    companion object {
        const val REQUESTED_API_VERSION = "2.0.99"
    }
}