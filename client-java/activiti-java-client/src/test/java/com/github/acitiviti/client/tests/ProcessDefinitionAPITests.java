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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.github.acitiviti.client.ProcessDefinitionAPI;
import com.github.acitiviti.client.model.common.ResultList;
import com.github.acitiviti.client.model.runtime.response.ProcessDefinitionRepresentation;
import com.github.acitiviti.client.ActivitiAPITestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retrofit2.Response;

public class ProcessDefinitionAPITests extends ActivitiAPITestCase
{
    @BeforeClass
    public void prepare() throws Exception
    {
        client = prepareClient(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    public void listProcessDefinitions() throws IOException
    {
        ProcessDefinitionAPI processDefAPI = client.getAPI(ProcessDefinitionAPI.class);

        Map<String,String> params=new HashMap<>();
        params.put("name","joe-flow");
        params.put("order","desc");
        params.put("sort","id");
        // Check if the user is present
        Response<ResultList<ProcessDefinitionRepresentation>> execute = processDefAPI.getRepositoryProcessDefinitions(params)
                .execute();
        System.out.println(execute.body());

    }
}
