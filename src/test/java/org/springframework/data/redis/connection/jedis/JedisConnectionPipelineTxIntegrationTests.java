/*
 * Copyright 2013-2022 the original author or authors.
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
package org.springframework.data.redis.connection.jedis;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Jennifer Hickey
 * @author Christoph Strobl
 */
public class JedisConnectionPipelineTxIntegrationTests extends JedisConnectionTransactionIntegrationTests {

	@Test
	@Disabled
	public void testRestoreBadData() {}

	@Test
	@Disabled
	public void testRestoreExistingKey() {}

	protected void initConnection() {
		connection.openPipeline();
		connection.multi();
	}

	@SuppressWarnings("unchecked")
	protected List<Object> getResults() {
		assertThat(connection.exec()).isNull();
		List<Object> pipelined = connection.closePipeline();
		// We expect only the results of exec to be in the closed pipeline
		assertThat(pipelined.size()).isEqualTo(1);
		List<Object> txResults = (List<Object>) pipelined.get(0);
		// Return exec results and this test should behave exactly like its superclass
		return txResults;
	}

	@Test
	@Disabled
	public void testListClientsContainsAtLeastOneElement() {}

}
