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

package com.github.acitiviti.client;

import com.github.acitiviti.client.model.runtime.response.ProcessDefinitionRepresentation;
import retrofit2.Call;
import retrofit2.http.GET;

import com.github.acitiviti.client.model.common.ResultList;

/**
 *
 * @author joezou
 * @date 2019/7/16 16:55
 **/
public interface ProcessDefinitionAPI
{

    @GET("service/repository/process-definitions")
    Call<ResultList<ProcessDefinitionRepresentation>> getRepositoryProcessDefinitions();

}
