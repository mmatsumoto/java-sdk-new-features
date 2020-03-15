#!/bin/sh

BUILD_DIR=java9-target
MODULE_LIB_BUILD_DIR=$BUILD_DIR/mlib

echo "1) Cleanup build directory @ $BUILD_DIR"
rm -rf $BUILD_DIR

echo "2) Creating build directory @ $BUILD_DIR"
mkdir $BUILD_DIR

echo "3) Creating module mlib directory @ $MODULE_LIB_BUILD_DIR"
mkdir $MODULE_LIB_BUILD_DIR

echo "4) Copying libs directory $MODULE_LIB_BUILD_DIR"
cp java9-module-one/target/java9-module-one-1.0-SNAPSHOT.jar $MODULE_LIB_BUILD_DIR
cp java9-module-two/target/java9-module-two-1.0-SNAPSHOT.jar $MODULE_LIB_BUILD_DIR
cp ~/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar $MODULE_LIB_BUILD_DIR
ls $MODULE_LIB_BUILD_DIR

echo
echo "5) Creating module-info.java for commons-lang3-3.9.jar"
cd $MODULE_LIB_BUILD_DIR
jdeps -verbose:class --generate-module-info . commons-lang3-3.9.jar
cat org.apache.commons.lang3/module-info.java

echo
echo "6) Compiling org.apache.commons.lang3/module-info.java"
javac --patch-module org.apache.commons.lang3=commons-lang3-3.9.jar org.apache.commons.lang3/module-info.java
ls org.apache.commons.lang3/

echo
echo "7) Pathing commons-lang3 with module-info.class"
jar -f commons-lang3-3.9.jar -d
jar uf commons-lang3-3.9.jar -C org.apache.commons.lang3 module-info.class

echo
echo "8) commons-lang3 after patching"
jar -f commons-lang3-3.9.jar -d

echo
echo "9) Removing org.apache.commons.lang3 directory"
rm -rf org.apache.commons.lang3

echo
echo "10) Generating small executable java version with jlink"
cd ..
jlink --compress=2 --module-path mlib --output build --add-modules org.apache.commons.lang3,module.one,module.two --launcher start=module.two/java9.module.two.SecondModule
#sed -i -e 's/JLINK_VM_OPTIONS=.*/JLINK_VM_OPTIONS=--enable-preview/' build/bin/run_second_module

echo
echo "11) cleaning mlib"
rm -rf mlib/

echo
echo "12) Listing build directory"
ls build

echo
echo "13) Finally, running the module"
./build/bin/start

echo
echo "14) Checking build/bin/java size: "
du -sh ./build/bin/java

echo
echo "15) Listing build/bin/java modules (compare with default $ java --list-modules)"
./build/bin/java --list-modules

cd ..

echo
exit 0
