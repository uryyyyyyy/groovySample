# StandardProject

## setup

`./gradlew [idea | eclipse]`

you can open [idea | eclipse] project

## run dynamically

`./gradlew run`

## architect

### Logging

use java.util.logger, see com.sample.utils.MyLogger

you have to call `MyLogger.setUpLogger` first

### properties

get from `conf/config.groovy`. see com.sample.utils.Config

## compile as executable jar

`./gradlew distZip`

you can get zip file in `build/distributions/`

**you have to add conf/config.groovy by your own**

## run executable jar

```
cd build/distributions/
unzip initialProject.zip
./bin/initialProject
```
