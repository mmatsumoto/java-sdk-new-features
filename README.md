# java-sdk-new-features

This is just a playground project to study the new JDK's features.

* Java 9: [examples](java9/src/main/java/org/example/module/one/java9/ExamplesJava9.java), Jigsaw ([java9-module-one](java9-module-one/src/main/java/), [java9-module-two](java9-module-two/src/main/java/))  

## Pre-requisites:

### jenv is your friend (https://www.jenv.be/)

```
$ brew install jenv
```

#### Load jenv automatically by adding the following to your profile:

eval "$(jenv init -)"
jenv init -

#### enable jenv plugins:

```
$ jenv enable-plugin export
$ jenv enable-plugin maven
// and/or
$ jenv enable-plugin graddle
```

#### Install a new jdk with brew

```
$ brew install openjdk@11
```

#### add to jenv

```
$ jenv add /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/
// another one
$ jenv add /Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home/
```

#### change your jdk with:
```
$ jenv global 1.8
// or
$ jenv global 11.0
// or 
$ jenv local 11.0
```
#### check the results:
```
$ jenv versions
```

#### update the PATH

```
$ alias jenv_set_java_home='export JAVA_HOME="$HOME/.jenv/versions/`jenv version-name`"'
$ jenv_set_java_home

// or if you have enabled the export plugin:
$ exec $SHELL -l
```


