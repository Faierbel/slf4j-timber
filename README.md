# slf4j-timber

This fork of the library supports only slf4j 2.0. Previous versions are supported by
the [original library.](https://github.com/patrickfav/slf4j-timber)

This library makes it easy to use existing libraries
which use SLF4J as their logging framework on the Google Android platform
in combination with [Jake Wharton's Timber logging utility.](https://github.com/JakeWharton/timber)

## Description

### Log level mapping

The priorities will be converted to LogCat's priority level and passed to
`Timber.log(...);`. The `Log.isLoggable()` are not respected here, since `Timber`
should be responsible to decide when to log what. The following table shows
the mapping from SLF4J log levels to LogCat log levels.

| SLF4J         | Android/Timber |
| ------------- |:-------------: |
| TRACE         | VERBOSE        |
| DEBUG         | DEBUG          |
| INFO          | INFO           |
| WARN          | WARN           |
| ERROR         | ERROR          |

### Logger name mapping

Logger instances created using the LoggerFactory are named either according to
the name given as parameter, or the fully qualified class name of the class given as
parameter. No truncating will take place since Timber handles this itself.

### Limitations

The Android-Timber binding implementation currently does not support Markers.
All logging methods which have a Marker parameter simply delegate to the
corresponding method without a Marker parameter, i.e., the Marker parameter
is silently ignored.