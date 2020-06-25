/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;
import java.io.IOException;
/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */
@SpringBootApplication(proxyBeanMethods = false)
public class PetClinicApplication {
	static final Counter requests = Counter.build()
     .name("requests_total").help("Total requests.").register();
	public static void main(String[] args) {
		try {
            HTTPServer server = new HTTPServer(8080);
        } catch (IOException e) {
            System.out.println("Failed to start metrics endpoint.");
            e.printStackTrace();
        }
		SpringApplication.run(PetClinicApplication.class, args);
	}

}
