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

package com.github.client.api;

import com.github.client.api.model.common.ResultList;
import com.github.client.api.model.runtime.request.CreateProcessInstanceRepresentation;
import com.github.client.api.model.runtime.response.ProcessInstanceRepresentation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 * @author joezou
 * @date 2019/7/16 16:55
 **/
public interface TaskAPI
{
    @POST("service/runtime/tasks")
    Call<ResultList<ProcessInstanceRepresentation>> getTasks(@Body CreateProcessInstanceRepresentation createProcessInstanceRepresentation);
}