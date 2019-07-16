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

package com.github.client.api.tests;

import com.github.client.api.ActivitiAPITestCase;
import com.github.client.api.ProcessInstanceAPI;
import com.github.client.api.TaskAPI;
import com.github.client.api.model.common.ResultList;
import com.github.client.api.model.runtime.request.CreateProcessInstanceRepresentation;
import com.github.client.api.model.runtime.response.ProcessInstanceRepresentation;
import com.github.client.api.model.runtime.response.TaskRepresentation;
import com.google.gson.Gson;
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
    public void createProcessInstances() throws IOException
    {
        TaskAPI taskAPI = client.getAPI(TaskAPI.class);

        Map<String,String> params=new HashMap<>();
        params.put("aaa","1111");
        // Check if the user is present
        Response<ResultList<TaskRepresentation>> execute = taskAPI.getTasks(params).execute();
        System.out.println(execute.body());

    }
}
