/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.github.acitiviti.client.tests;

import com.github.acitiviti.client.BPMClient;
import com.github.acitiviti.client.ProcessInstanceAPI;
import com.github.acitiviti.client.TaskAPI;
import com.github.acitiviti.client.ActivitiAPITestCase;
import com.github.acitiviti.client.model.common.ResultList;
import com.github.acitiviti.client.model.runtime.request.CreateProcessInstanceRepresentation;
import com.github.acitiviti.client.model.runtime.request.TaskAction;
import com.github.acitiviti.client.model.runtime.response.ProcessInstanceRepresentation;
import com.github.acitiviti.client.model.runtime.response.TaskRepresentation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TaskAPITests extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void getTasks() throws IOException
    {
        TaskAPI taskAPI = client.getAPI(TaskAPI.class);

        Map<String,String> params=new HashMap<>();
        params.put("aaa","1111");
        // Check if the user is present
        Response<ResultList<TaskRepresentation>> execute = taskAPI.getTasks(params).execute();
        System.out.println(execute.body());

    }

    @Test
    public void taskAction() throws IOException
    {
        BPMClient bpmClient = prepareClient(TEST_ENDPOINT, "joe", "joe");

        TaskAPI taskAPI = bpmClient.getAPI(TaskAPI.class);

        TaskAction taskAction=new TaskAction();
        taskAction.setAction("complete");
        // Check if the user is present
        Response<Void> execute = taskAPI.updateTaskAction("10114", taskAction).execute();
        System.out.println(execute.body());

    }

}
