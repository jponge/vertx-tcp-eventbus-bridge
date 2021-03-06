/*
 * Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

/**
 * = Vert.x-tcp-eventbus-bridge
 * :toc: left
 *
 * Vert.x-tcp-eventbus-bridge is a TCP bridge to Vert.x EventBus. To use this project, add the following
 * dependency to the _dependencies_ section of your build descriptor:
 *
 * * Maven (in your `pom.xml`):
 *
 * [source,xml,subs="+attributes"]
 * ----
 * <dependency>
 *   <groupId>${maven.groupId}</groupId>
 *   <artifactId>${maven.artifactId}</artifactId>
 *   <version>${maven.version}</version>
 * </dependency>
 * ----
 *
 * * Gradle (in your `build.gradle` file):
 *
 * [source,groovy,subs="+attributes"]
 * ----
 * compile '${maven.groupId}:${maven.artifactId}:${maven.version}'
 * ----
 *
 * The TCP EventBus bridge as its name states is a bridge built on top of TCP, meaning that any application able to
 * create sockets can use the EventBus from a remote Vert.x instance.
 *
 * The protocol has been kept as simple as possible and communications use Frames both ways. A typical frame looks like
 * this:
 *
 * ----
 * <Length:Int32>{type: String, headers: Object, body: Object}
 * ----
 *
 * The wire format is 4 bytes for the message length followed by a json document (there is no need to remove new lines
 * or white space.
 *
 * Every received frame with a reply address will return a frame. In case of error even if there is no reply address the
 * server might return a message, in this case the type will be "err".
 *
 * An example NodeJS client is available in the source of the project, this client uses the same API as the SockJS
 * counter part so it will make it easier to switch implementations.
 *
 * The use case for the TCP bridge vs the SockJS bridge if for applications that are more constrained in resources and
 * need to be lightweight since the whole HTTP WebSockets is replaced with plain TCP sockets.
 *
 * An example on how to get started with this bridge could be:
 *
 * * [source,$lang]
 * ----
 * {@link examples.TCPBridgeExamples#example1}
 * ----
 *
 */
@ModuleGen(name = "vertx-tcp-eventbus-bridge", groupPackage = "io.vertx.ext")
@Document(fileName = "index.adoc")

package io.vertx.ext.eventbus.bridge.tcp;

import io.vertx.codegen.annotations.ModuleGen;
import io.vertx.docgen.Document;
