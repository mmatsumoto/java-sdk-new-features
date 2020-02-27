# java-sdk-new-features

This is just a playground project to study the new JDK's features.

* Java 9: [examples](java9/src/main/java/org/example/module/one/java9/), Jigsaw ([java9-module-one](java9-module-one/src/main/java/), [java9-module-two](java9-module-two/src/main/java/))  

## Prerequisites:

### Install JDK 13

For Mac:
```
$ brew tap AdoptOpenJDK/openjdk
// if you want to list the available versions:
$ brew search adoptopenjdk

$ brew cask install adoptopenjdk13
```

### Install jenv (https://www.jenv.be/)

```
$ brew install jenv
```

#### Load jenv automatically by adding the following to your (bash,zsh) profile :

```
eval "$(jenv init -)"
jenv init -
```

#### enable jenv plugins:

```
$ jenv enable-plugin export

// and/or
$ jenv enable-plugin maven
$ jenv enable-plugin graddle
```

#### add the new jdk to jenv environment

```
$ jenv add /Library/Java/JavaVirtualMachines/adoptopenjdk-13.jdk/Contents/Home/

// another one 
$ jenv add /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/
$ jenv add /Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home/
```

#### change your jdk with:

```
$ jenv global 11.0

// or
$ jenv global 1.8
$ jenv global 11.0

// you can use 'local' instead of 'global'. this will create a .java-version file
// and the jvm version you chose will be set up for the current directory only.
// you can remove it to go back to global
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

// or if you have enabled the export plugin just type:
$ exec $SHELL -l

// or relogin
```

