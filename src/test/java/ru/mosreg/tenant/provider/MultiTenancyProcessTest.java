package ru.mosreg.tenant.provider;/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MultiTenancyProcessTest {

  @Rule
  public ProcessEngineRule processEngineRule = new ProcessEngineRule();

  private RepositoryService repositoryService;
  private RuntimeService runtimeService;
//  private TaskService taskService;
//  private IdentityService identityService;

  @Before
  public void initServices() {
    repositoryService = processEngineRule.getRepositoryService();
    runtimeService = processEngineRule.getRuntimeService();
//    taskService = processEngineRule.getTaskService();
//    identityService = processEngineRule.getIdentityService();
  }

  @Test
  public void testTenantIdProvider() {
    // deploy shared process definitions (which belongs to no tenant)
    repositoryService
      .createDeployment()
      .addClasspathResource("diagram_1.bpmn")
      .deploy();

    runtimeService.startProcessInstanceByKey("MultiTenancyProcess");

    // check that the process instance got the tenant id from the custom tenant id provider
    ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processDefinitionKey("MultiTenancyProcess").singleResult();
    assertThat(processInstance.getTenantId(), is("qqqwwweee"));
  }
}
