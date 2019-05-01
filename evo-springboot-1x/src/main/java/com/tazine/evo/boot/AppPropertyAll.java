package com.tazine.evo.boot;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 一个Java应用中有那些参数
 *
 * @author frank
 * @date 2019/05/01
 */
@Component
public class AppPropertyAll implements InitializingBean {

    @Autowired
    private ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {
        // System.getenv() 获取当前系统环境参数
        System.out.println(JSON.toJSONString(System.getenv()));

        // System.getProperties() 当前的系统配置，主要是JVM配置
        System.out.println(JSON.toJSONString(System.getProperties()));

        // context.getEnvironment() 获取当前应用上下文参数，可以查看过滤器路径
        System.out.println(JSON.toJSONString(context.getEnvironment()));
    }

    // System.getenv() 获取当前系统环境参数
    //{
    //    "PATH":"/usr/local/opt/postgresql@9.6/bin:/usr/local/opt/mongodb@3.4/bin:/usr/local/opt/node@8/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/share/dotnet:~/.dotnet/tools:/Library/Frameworks/Mono.framework/Versions/Current/Commands:/Applications/Xamarin Workbooks.app/Contents/SharedSupport/path-bin",
    //    "JAVA_MAIN_CLASS_18729":"com.tazine.evo.boot.Application",
    //    "SHELL":"/bin/zsh",
    //    "PAGER":"less",
    //    "LSCOLORS":"Gxfxcxdxbxegedabagacad",
    //    "OLDPWD":"/Applications/IntelliJ IDEA.app/Contents/bin",
    //    "USER":"jiaer.ly",
    //    "VERSIONER_PYTHON_PREFER_32_BIT":"no",
    //    "ZSH":"/Users/jiaer.ly/.oh-my-zsh",
    //    "TMPDIR":"/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/",
    //    "SSH_AUTH_SOCK":"/private/tmp/com.apple.launchd.Qo8s9fG9qW/Listeners",
    //    "XPC_FLAGS":"0x0",
    //    "VERSIONER_PYTHON_VERSION":"2.7",
    //    "__CF_USER_TEXT_ENCODING":"0x1F5:0x19:0x34",
    //    "Apple_PubSub_Socket_Render":"/private/tmp/com.apple.launchd.ojXkVxOW0m/Render",
    //    "LOGNAME":"jiaer.ly",
    //    "LESS":"-R",
    //    "LC_CTYPE":"",
    //    "PWD":"/Users/jiaer.ly/codeplay/tazine/EVO-World",
    //    "XPC_SERVICE_NAME":"com.jetbrains.intellij.10184",
    //    "HOME":"/Users/jiaer.ly"
    //}

    // System.getProperties() 当前的系统配置，主要是JVM配置
    //{
    //    "java.runtime.name":"Java(TM) SE Runtime Environment",
    //    "spring.output.ansi.enabled":"always",
    //    "sun.boot.library.path":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib",
    //    "java.vm.version":"25.151-b12",
    //    "gopherProxySet":"false",
    //    "java.vm.vendor":"Oracle Corporation",
    //    "java.vendor.url":"http://java.oracle.com/",
    //    "java.rmi.server.randomIDs":"true",
    //    "path.separator":":",
    //    "java.vm.name":"Java HotSpot(TM) 64-Bit Server VM",
    //    "file.encoding.pkg":"sun.io",
    //    "user.country":"CN",
    //    "sun.java.launcher":"SUN_STANDARD",
    //    "sun.os.patch.level":"unknown",
    //    "PID":"18729",
    //    "java.vm.specification.name":"Java Virtual Machine Specification",
    //    "user.dir":"/Users/jiaer.ly/codeplay/tazine/EVO-World",
    //    "java.runtime.version":"1.8.0_151-b12",
    //    "java.awt.graphicsenv":"sun.awt.CGraphicsEnvironment",
    //    "org.jboss.logging.provider":"slf4j",
    //    "java.endorsed.dirs":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/endorsed",
    //    "os.arch":"x86_64",
    //    "java.io.tmpdir":"/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/",
    //    "line.separator":"
    //    ",
    //    "java.vm.specification.vendor":"Oracle Corporation",
    //    "os.name":"Mac OS X",
    //    "sun.jnu.encoding":"UTF-8",
    //    "spring.beaninfo.ignore":"true",
    //    "java.library.path":"/Users/jiaer.ly/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.",
    //    "java.specification.name":"Java Platform API Specification",
    //    "java.class.version":"52.0",
    //    "sun.management.compiler":"HotSpot 64-Bit Tiered Compilers",
    //    "spring.liveBeansView.mbeanDomain":"",
    //    "os.version":"10.14",
    //    "user.home":"/Users/jiaer.ly",
    //    "catalina.useNaming":"false",
    //    "user.timezone":"Asia/Shanghai",
    //    "java.awt.printerjob":"sun.lwawt.macosx.CPrinterJob",
    //    "file.encoding":"UTF-8",
    //    "java.specification.version":"1.8",
    //    "catalina.home":"/private/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/tomcat.1348610579127732415.8080",
    //    "java.class.path":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/tools.jar:/Users/jiaer.ly/codeplay/tazine/EVO-World/evo-springboot-1x/target/classes:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-web/1.5.20.RELEASE/spring-boot-starter-web-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter/1.5.20.RELEASE/spring-boot-starter-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot/1.5.20.RELEASE/spring-boot-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.5.20.RELEASE/spring-boot-autoconfigure-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-logging/1.5.20.RELEASE/spring-boot-starter-logging-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/ch/qos/logback/logback-classic/1.1.11/logback-classic-1.1.11.jar:/Users/jiaer.ly/.m2/repository/ch/qos/logback/logback-core/1.1.11/logback-core-1.1.11.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.26/jcl-over-slf4j-1.7.26.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/jul-to-slf4j/1.7.26/jul-to-slf4j-1.7.26.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/log4j-over-slf4j/1.7.26/log4j-over-slf4j-1.7.26.jar:/Users/jiaer.ly/.m2/repository/org/yaml/snakeyaml/1.17/snakeyaml-1.17.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/1.5.20.RELEASE/spring-boot-starter-tomcat-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/8.5.39/tomcat-embed-core-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/tomcat-annotations-api/8.5.39/tomcat-annotations-api-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/8.5.39/tomcat-embed-el-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/8.5.39/tomcat-embed-websocket-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/hibernate/hibernate-validator/5.3.6.Final/hibernate-validator-5.3.6.Final.jar:/Users/jiaer.ly/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/Users/jiaer.ly/.m2/repository/org/jboss/logging/jboss-logging/3.3.0.Final/jboss-logging-3.3.0.Final.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/classmate/1.3.1/classmate-1.3.1.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.8.11.3/jackson-databind-2.8.11.3.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.8.0/jackson-annotations-2.8.0.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.8.10/jackson-core-2.8.10.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-web/4.3.23.RELEASE/spring-web-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-beans/4.3.23.RELEASE/spring-beans-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-context/4.3.23.RELEASE/spring-context-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-webmvc/4.3.23.RELEASE/spring-webmvc-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-expression/4.3.23.RELEASE/spring-expression-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/1.5.20.RELEASE/spring-boot-starter-actuator-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-actuator/1.5.20.RELEASE/spring-boot-actuator-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/projectlombok/lombok/1.16.18/lombok-1.16.18.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-core/4.3.23.RELEASE/spring-core-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/retry/spring-retry/1.2.2.RELEASE/spring-retry-1.2.2.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/aspectj/aspectjweaver/1.8.6/aspectjweaver-1.8.6.jar:/Users/jiaer.ly/.m2/repository/com/github/rholder/guava-retrying/2.0.0/guava-retrying-2.0.0.jar:/Users/jiaer.ly/.m2/repository/com/google/guava/guava/25.1-jre/guava-25.1-jre.jar:/Users/jiaer.ly/.m2/repository/org/checkerframework/checker-qual/2.0.0/checker-qual-2.0.0.jar:/Users/jiaer.ly/.m2/repository/com/google/errorprone/error_prone_annotations/2.1.3/error_prone_annotations-2.1.3.jar:/Users/jiaer.ly/.m2/repository/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1.jar:/Users/jiaer.ly/.m2/repository/org/codehaus/mojo/animal-sniffer-annotations/1.14/animal-sniffer-annotations-1.14.jar:/Users/jiaer.ly/.m2/repository/com/google/code/findbugs/jsr305/2.0.2/jsr305-2.0.2.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-aop/1.5.20.RELEASE/spring-boot-starter-aop-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-aop/4.3.23.RELEASE/spring-aop-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/1.5.20.RELEASE/spring-boot-starter-jdbc-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/tomcat-jdbc/8.5.39/tomcat-jdbc-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/tomcat-juli/8.5.39/tomcat-juli-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-jdbc/4.3.23.RELEASE/spring-jdbc-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-tx/4.3.23.RELEASE/spring-tx-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/mysql/mysql-connector-java/5.1.46/mysql-connector-java-5.1.46.jar:/Users/jiaer.ly/.m2/repository/commons-io/commons-io/2.6/commons-io-2.6.jar:/Users/jiaer.ly/.m2/repository/com/alibaba/fastjson/1.2.51/fastjson-1.2.51.jar:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar",
    //    "user.name":"jiaer.ly",
    //    "com.sun.management.jmxremote":"",
    //    "java.vm.specification.version":"1.8",
    //    "sun.java.command":"com.tazine.evo.boot.Application",
    //    "java.home":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre",
    //    "sun.arch.data.model":"64",
    //    "user.language":"zh",
    //    "java.specification.vendor":"Oracle Corporation",
    //    "awt.toolkit":"sun.lwawt.macosx.LWCToolkit",
    //    "java.vm.info":"mixed mode",
    //    "java.version":"1.8.0_151",
    //    "java.ext.dirs":"/Users/jiaer.ly/Library/Java/Extensions:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java",
    //    "sun.boot.class.path":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/sunrsasign.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/classes",
    //    "java.awt.headless":"true",
    //    "java.vendor":"Oracle Corporation",
    //    "catalina.base":"/private/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/tomcat.1348610579127732415.8080",
    //    "spring.application.admin.enabled":"true",
    //    "file.separator":"/",
    //    "java.vendor.url.bug":"http://bugreport.sun.com/bugreport/",
    //    "sun.io.unicode.encoding":"UnicodeBig",
    //    "sun.cpu.endian":"little",
    //    "sun.cpu.isalist":""
    //}

    // context.getEnvironment() 获取当前应用上下文参数，可以查看过滤器路径
    //{
    //    "activeProfiles":[
    //
    //],
    //    "conversionService":{
    //
    //},
    //    "defaultProfiles":[
    //    "default"
    //],
    //    "propertySources":[
    //    {
    //        "name":"servletConfigInitParams",
    //        "source":{
    //
    //    }
    //    },
    //    {
    //        "name":"servletContextInitParams",
    //        "propertyNames":[
    //
    //        ],
    //        "source":{
    //        "attributeNames":[
    //        "javax.servlet.context.tempdir",
    //            "org.apache.catalina.resources",
    //            "org.springframework.web.context.WebApplicationContext.ROOT",
    //            "org.springframework.web.context.support.ServletContextScope",
    //            "org.apache.tomcat.InstanceManager",
    //            "org.apache.catalina.jsp_classpath",
    //            "javax.websocket.server.ServerContainer",
    //            "org.apache.tomcat.JarScanner"
    //            ],
    //        "contextPath":"/home",
    //            "defaultSessionTrackingModes":[
    //        "COOKIE",
    //            "URL"
    //            ],
    //        "effectiveMajorVersion":3,
    //            "effectiveMinorVersion":0,
    //            "effectiveSessionTrackingModes":[
    //        "COOKIE",
    //            "URL"
    //            ],
    //        "filterRegistrations":{
    //            "requestContextFilter":{
    //                "className":"org.springframework.boot.web.filter.OrderedRequestContextFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"requestContextFilter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            },
    //            "applicationContextIdFilter":{
    //                "className":"org.springframework.boot.web.filter.ApplicationContextHeaderFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"applicationContextIdFilter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            },
    //            "Tomcat WebSocket (JSR356) Filter":{
    //                "className":"org.apache.tomcat.websocket.server.WsFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"Tomcat WebSocket (JSR356) Filter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            },
    //            "httpPutFormContentFilter":{
    //                "className":"org.springframework.boot.web.filter.OrderedHttpPutFormContentFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"httpPutFormContentFilter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            },
    //            "hiddenHttpMethodFilter":{
    //                "className":"org.springframework.boot.web.filter.OrderedHiddenHttpMethodFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"hiddenHttpMethodFilter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            },
    //            "characterEncodingFilter":{
    //                "className":"org.springframework.boot.web.filter.OrderedCharacterEncodingFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"characterEncodingFilter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            },
    //            "webRequestLoggingFilter":{
    //                "className":"org.springframework.boot.actuate.trace.WebRequestTraceFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"webRequestLoggingFilter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            },
    //            "metricsFilter":{
    //                "className":"org.springframework.boot.actuate.autoconfigure.MetricsFilter",
    //                    "initParameters":{
    //
    //                },
    //                "name":"metricsFilter",
    //                    "servletNameMappings":[
    //
    //                    ],
    //                "urlPatternMappings":[
    //                "/*"
    //                    ]
    //            }
    //        },
    //        "initParameterNames":[
    //
    //            ],
    //        "majorVersion":3,
    //            "minorVersion":1,
    //            "serverInfo":"Apache Tomcat/8.5.39",
    //            "servletContextName":"application",
    //            "servletNames":[
    //
    //            ],
    //        "servletRegistrations":{
    //            "default":{
    //                "className":"org.apache.catalina.servlets.DefaultServlet",
    //                    "initParameters":{
    //                    "listings":"false",
    //                        "debug":"0"
    //                },
    //                "mappings":[
    //
    //                    ],
    //                "name":"default"
    //            },
    //            "dispatcherServlet":{
    //                "className":"org.springframework.web.servlet.DispatcherServlet",
    //                    "initParameters":{
    //
    //                },
    //                "mappings":[
    //                "/"
    //                    ],
    //                "name":"dispatcherServlet"
    //            }
    //        },
    //        "servlets":[
    //
    //            ],
    //        "sessionCookieConfig":{
    //            "httpOnly":false,
    //                "maxAge":-1,
    //                "secure":false
    //        },
    //        "sessionTimeout":30,
    //            "virtualServerName":"Tomcat/localhost"
    //    }
    //    },
    //    {
    //        "name":"systemProperties",
    //        "propertyNames":[
    //        "java.runtime.name",
    //            "spring.output.ansi.enabled",
    //            "sun.boot.library.path",
    //            "java.vm.version",
    //            "gopherProxySet",
    //            "java.vm.vendor",
    //            "java.vendor.url",
    //            "java.rmi.server.randomIDs",
    //            "path.separator",
    //            "java.vm.name",
    //            "file.encoding.pkg",
    //            "user.country",
    //            "sun.java.launcher",
    //            "sun.os.patch.level",
    //            "PID",
    //            "java.vm.specification.name",
    //            "user.dir",
    //            "java.runtime.version",
    //            "java.awt.graphicsenv",
    //            "org.jboss.logging.provider",
    //            "java.endorsed.dirs",
    //            "os.arch",
    //            "java.io.tmpdir",
    //            "line.separator",
    //            "java.vm.specification.vendor",
    //            "os.name",
    //            "sun.jnu.encoding",
    //            "spring.beaninfo.ignore",
    //            "java.library.path",
    //            "java.specification.name",
    //            "java.class.version",
    //            "sun.management.compiler",
    //            "spring.liveBeansView.mbeanDomain",
    //            "os.version",
    //            "user.home",
    //            "catalina.useNaming",
    //            "user.timezone",
    //            "java.awt.printerjob",
    //            "file.encoding",
    //            "java.specification.version",
    //            "catalina.home",
    //            "java.class.path",
    //            "user.name",
    //            "com.sun.management.jmxremote",
    //            "java.vm.specification.version",
    //            "sun.java.command",
    //            "java.home",
    //            "sun.arch.data.model",
    //            "user.language",
    //            "java.specification.vendor",
    //            "awt.toolkit",
    //            "java.vm.info",
    //            "java.version",
    //            "java.ext.dirs",
    //            "sun.boot.class.path",
    //            "java.awt.headless",
    //            "java.vendor",
    //            "catalina.base",
    //            "spring.application.admin.enabled",
    //            "file.separator",
    //            "java.vendor.url.bug",
    //            "sun.io.unicode.encoding",
    //            "sun.cpu.endian",
    //            "sun.cpu.isalist"
    //        ],
    //        "source":{
    //        "java.runtime.name":"Java(TM) SE Runtime Environment",
    //            "spring.output.ansi.enabled":"always",
    //            "sun.boot.library.path":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib",
    //            "java.vm.version":"25.151-b12",
    //            "gopherProxySet":"false",
    //            "java.vm.vendor":"Oracle Corporation",
    //            "java.vendor.url":"http://java.oracle.com/",
    //            "java.rmi.server.randomIDs":"true",
    //            "path.separator":":",
    //            "java.vm.name":"Java HotSpot(TM) 64-Bit Server VM",
    //            "file.encoding.pkg":"sun.io",
    //            "user.country":"CN",
    //            "sun.java.launcher":"SUN_STANDARD",
    //            "sun.os.patch.level":"unknown",
    //            "PID":"18729",
    //            "java.vm.specification.name":"Java Virtual Machine Specification",
    //            "user.dir":"/Users/jiaer.ly/codeplay/tazine/EVO-World",
    //            "java.runtime.version":"1.8.0_151-b12",
    //            "java.awt.graphicsenv":"sun.awt.CGraphicsEnvironment",
    //            "org.jboss.logging.provider":"slf4j",
    //            "java.endorsed.dirs":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/endorsed",
    //            "os.arch":"x86_64",
    //            "java.io.tmpdir":"/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/",
    //            "line.separator":"
    //        ",
    //        "java.vm.specification.vendor":"Oracle Corporation",
    //            "os.name":"Mac OS X",
    //            "sun.jnu.encoding":"UTF-8",
    //            "spring.beaninfo.ignore":"true",
    //            "java.library.path":"/Users/jiaer.ly/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.",
    //            "java.specification.name":"Java Platform API Specification",
    //            "java.class.version":"52.0",
    //            "sun.management.compiler":"HotSpot 64-Bit Tiered Compilers",
    //            "spring.liveBeansView.mbeanDomain":"",
    //            "os.version":"10.14",
    //            "user.home":"/Users/jiaer.ly",
    //            "catalina.useNaming":"false",
    //            "user.timezone":"Asia/Shanghai",
    //            "java.awt.printerjob":"sun.lwawt.macosx.CPrinterJob",
    //            "file.encoding":"UTF-8",
    //            "java.specification.version":"1.8",
    //            "catalina.home":"/private/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/tomcat.1348610579127732415.8080",
    //            "java.class.path":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/tools.jar:/Users/jiaer.ly/codeplay/tazine/EVO-World/evo-springboot-1x/target/classes:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-web/1.5.20.RELEASE/spring-boot-starter-web-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter/1.5.20.RELEASE/spring-boot-starter-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot/1.5.20.RELEASE/spring-boot-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.5.20.RELEASE/spring-boot-autoconfigure-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-logging/1.5.20.RELEASE/spring-boot-starter-logging-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/ch/qos/logback/logback-classic/1.1.11/logback-classic-1.1.11.jar:/Users/jiaer.ly/.m2/repository/ch/qos/logback/logback-core/1.1.11/logback-core-1.1.11.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.26/jcl-over-slf4j-1.7.26.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/jul-to-slf4j/1.7.26/jul-to-slf4j-1.7.26.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/log4j-over-slf4j/1.7.26/log4j-over-slf4j-1.7.26.jar:/Users/jiaer.ly/.m2/repository/org/yaml/snakeyaml/1.17/snakeyaml-1.17.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/1.5.20.RELEASE/spring-boot-starter-tomcat-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/8.5.39/tomcat-embed-core-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/tomcat-annotations-api/8.5.39/tomcat-annotations-api-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/8.5.39/tomcat-embed-el-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/8.5.39/tomcat-embed-websocket-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/hibernate/hibernate-validator/5.3.6.Final/hibernate-validator-5.3.6.Final.jar:/Users/jiaer.ly/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/Users/jiaer.ly/.m2/repository/org/jboss/logging/jboss-logging/3.3.0.Final/jboss-logging-3.3.0.Final.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/classmate/1.3.1/classmate-1.3.1.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.8.11.3/jackson-databind-2.8.11.3.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.8.0/jackson-annotations-2.8.0.jar:/Users/jiaer.ly/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.8.10/jackson-core-2.8.10.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-web/4.3.23.RELEASE/spring-web-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-beans/4.3.23.RELEASE/spring-beans-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-context/4.3.23.RELEASE/spring-context-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-webmvc/4.3.23.RELEASE/spring-webmvc-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-expression/4.3.23.RELEASE/spring-expression-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/1.5.20.RELEASE/spring-boot-starter-actuator-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-actuator/1.5.20.RELEASE/spring-boot-actuator-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/projectlombok/lombok/1.16.18/lombok-1.16.18.jar:/Users/jiaer.ly/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-core/4.3.23.RELEASE/spring-core-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/retry/spring-retry/1.2.2.RELEASE/spring-retry-1.2.2.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/aspectj/aspectjweaver/1.8.6/aspectjweaver-1.8.6.jar:/Users/jiaer.ly/.m2/repository/com/github/rholder/guava-retrying/2.0.0/guava-retrying-2.0.0.jar:/Users/jiaer.ly/.m2/repository/com/google/guava/guava/25.1-jre/guava-25.1-jre.jar:/Users/jiaer.ly/.m2/repository/org/checkerframework/checker-qual/2.0.0/checker-qual-2.0.0.jar:/Users/jiaer.ly/.m2/repository/com/google/errorprone/error_prone_annotations/2.1.3/error_prone_annotations-2.1.3.jar:/Users/jiaer.ly/.m2/repository/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1.jar:/Users/jiaer.ly/.m2/repository/org/codehaus/mojo/animal-sniffer-annotations/1.14/animal-sniffer-annotations-1.14.jar:/Users/jiaer.ly/.m2/repository/com/google/code/findbugs/jsr305/2.0.2/jsr305-2.0.2.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-aop/1.5.20.RELEASE/spring-boot-starter-aop-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-aop/4.3.23.RELEASE/spring-aop-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/1.5.20.RELEASE/spring-boot-starter-jdbc-1.5.20.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/tomcat-jdbc/8.5.39/tomcat-jdbc-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/apache/tomcat/tomcat-juli/8.5.39/tomcat-juli-8.5.39.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-jdbc/4.3.23.RELEASE/spring-jdbc-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/org/springframework/spring-tx/4.3.23.RELEASE/spring-tx-4.3.23.RELEASE.jar:/Users/jiaer.ly/.m2/repository/mysql/mysql-connector-java/5.1.46/mysql-connector-java-5.1.46.jar:/Users/jiaer.ly/.m2/repository/commons-io/commons-io/2.6/commons-io-2.6.jar:/Users/jiaer.ly/.m2/repository/com/alibaba/fastjson/1.2.51/fastjson-1.2.51.jar:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar",
    //            "user.name":"jiaer.ly",
    //            "com.sun.management.jmxremote":"",
    //            "java.vm.specification.version":"1.8",
    //            "sun.java.command":"com.tazine.evo.boot.Application",
    //            "java.home":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre",
    //            "sun.arch.data.model":"64",
    //            "user.language":"zh",
    //            "java.specification.vendor":"Oracle Corporation",
    //            "awt.toolkit":"sun.lwawt.macosx.LWCToolkit",
    //            "java.vm.info":"mixed mode",
    //            "java.version":"1.8.0_151",
    //            "java.ext.dirs":"/Users/jiaer.ly/Library/Java/Extensions:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java",
    //            "sun.boot.class.path":"/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/sunrsasign.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/classes",
    //            "java.awt.headless":"true",
    //            "java.vendor":"Oracle Corporation",
    //            "catalina.base":"/private/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/tomcat.1348610579127732415.8080",
    //            "spring.application.admin.enabled":"true",
    //            "file.separator":"/",
    //            "java.vendor.url.bug":"http://bugreport.sun.com/bugreport/",
    //            "sun.io.unicode.encoding":"UnicodeBig",
    //            "sun.cpu.endian":"little",
    //            "sun.cpu.isalist":""
    //    }
    //    },
    //    {
    //        "name":"systemEnvironment",
    //        "propertyNames":[
    //        "PATH",
    //            "JAVA_MAIN_CLASS_18729",
    //            "SHELL",
    //            "PAGER",
    //            "LSCOLORS",
    //            "OLDPWD",
    //            "USER",
    //            "VERSIONER_PYTHON_PREFER_32_BIT",
    //            "ZSH",
    //            "TMPDIR",
    //            "SSH_AUTH_SOCK",
    //            "XPC_FLAGS",
    //            "VERSIONER_PYTHON_VERSION",
    //            "__CF_USER_TEXT_ENCODING",
    //            "Apple_PubSub_Socket_Render",
    //            "LOGNAME",
    //            "LESS",
    //            "LC_CTYPE",
    //            "PWD",
    //            "XPC_SERVICE_NAME",
    //            "HOME"
    //        ],
    //        "source":{
    //        "PATH":"/usr/local/opt/postgresql@9.6/bin:/usr/local/opt/mongodb@3.4/bin:/usr/local/opt/node@8/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/share/dotnet:~/.dotnet/tools:/Library/Frameworks/Mono.framework/Versions/Current/Commands:/Applications/Xamarin Workbooks.app/Contents/SharedSupport/path-bin",
    //            "JAVA_MAIN_CLASS_18729":"com.tazine.evo.boot.Application",
    //            "SHELL":"/bin/zsh",
    //            "PAGER":"less",
    //            "LSCOLORS":"Gxfxcxdxbxegedabagacad",
    //            "OLDPWD":"/Applications/IntelliJ IDEA.app/Contents/bin",
    //            "USER":"jiaer.ly",
    //            "VERSIONER_PYTHON_PREFER_32_BIT":"no",
    //            "ZSH":"/Users/jiaer.ly/.oh-my-zsh",
    //            "TMPDIR":"/var/folders/3t/9cwjhmq17233m6tc0r9lgclc0000gn/T/",
    //            "SSH_AUTH_SOCK":"/private/tmp/com.apple.launchd.Qo8s9fG9qW/Listeners",
    //            "XPC_FLAGS":"0x0",
    //            "VERSIONER_PYTHON_VERSION":"2.7",
    //            "__CF_USER_TEXT_ENCODING":"0x1F5:0x19:0x34",
    //            "Apple_PubSub_Socket_Render":"/private/tmp/com.apple.launchd.ojXkVxOW0m/Render",
    //            "LOGNAME":"jiaer.ly",
    //            "LESS":"-R",
    //            "LC_CTYPE":"",
    //            "PWD":"/Users/jiaer.ly/codeplay/tazine/EVO-World",
    //            "XPC_SERVICE_NAME":"com.jetbrains.intellij.10184",
    //            "HOME":"/Users/jiaer.ly"
    //    }
    //    },
    //    {
    //        "name":"random",
    //        "source":{
    //
    //    }
    //    },
    //    {
    //        "name":"applicationConfig: [classpath:/application.yml]",
    //        "propertyNames":[
    //        "spring.datasource.url",
    //            "spring.datasource.username",
    //            "spring.datasource.password",
    //            "spring.datasource.driver-class-name",
    //            "server.context-path"
    //        ],
    //        "source":{
    //        "spring.datasource.url":"jdbc:mysql://127.0.0.1:3306/demo",
    //            "spring.datasource.username":"root",
    //            "spring.datasource.password":"jiaer.ly",
    //            "spring.datasource.driver-class-name":"com.mysql.jdbc.Driver",
    //            "server.context-path":"/home"
    //    }
    //    }
    //],
    //    "systemEnvironment":{
    //    "$ref":"$.null.source"
    //},
    //    "systemProperties":{
    //    "$ref":"$.null.source"
    //}
    //}
}
