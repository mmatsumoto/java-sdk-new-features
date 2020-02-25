# java-sdk-new-features

This is just a playground project to study the new JDK's features.

* Java 9 

## Pre-requisites:

### jenv is your friend

```
$ brew install jenv
```

#### Load jenv automatically by adding the following to your profile:

eval "$(jenv init -)"
jenv init -

#### Install a new jdk with brew

```
$ brew install openjdk@11
```

#### add to jenv

```
$ jenv add /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/
// or
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
```


