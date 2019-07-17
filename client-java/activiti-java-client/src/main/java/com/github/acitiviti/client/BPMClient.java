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

import com.github.acitiviti.client.model.deserializer.ResultListDeserializer;
import com.github.acitiviti.client.model.runtime.response.ProcessDefinitionRepresentation;
import okhttp3.OkHttpClient;

import com.github.acitiviti.client.model.common.ResultList;
import com.github.activiti.client.AbstractClient;
import com.github.activiti.client.RestClient;
import com.github.activiti.client.utils.ISO8601Utils;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BPMClient extends AbstractClient<BPMClient>
{
    protected static final Object LOCK = new Object();

    protected static BPMClient mInstance;


    protected ProcessInstanceAPI processInstanceAPI;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    // ///////////////////////////////////////////////////////////////////////////
    public static BPMClient getInstance()
    {
        synchronized (LOCK)
        {
            return mInstance;
        }
    }

    protected BPMClient(RestClient restClient, OkHttpClient okHttpClient)
    {
        super(restClient, okHttpClient);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // API REGISTRY
    // ///////////////////////////////////////////////////////////////////////////

    public ProcessInstanceAPI getProcessInstanceAPI()
    {
        return processInstanceAPI = (processInstanceAPI == null) ? getAPI(ProcessInstanceAPI.class)
                : processInstanceAPI;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // BUILDER
    // ///////////////////////////////////////////////////////////////////////////
    public static class Builder extends AbstractClient.Builder<BPMClient>
    {

        @Override
        public String getUSerAgent()
        {
            return "Alfresco-BPM-Client/" + Version.SDK;
        }

        @Override
        public BPMClient create(RestClient restClient, OkHttpClient okHttpClient)
        {
            return new BPMClient(new RestClient(endpoint, retrofit, username), okHttpClient);
        }

        @Override
        public GsonBuilder getDefaultGsonBuilder()
        {
            return Utils.getDefaultGsonBuilder();
        }

        // BUILD
        // ///////////////////////////////////////////////////////////////////////////

        public BPMClient build()
        {
            mInstance = super.build();
            return mInstance;
        }
    }

    // ///////////////////////////////////////////////////////////////////////////
    // UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public static class Utils
    {
        public static GsonBuilder getDefaultGsonBuilder()
        {
            return new GsonBuilder().setDateFormat(ISO8601Utils.DATE_ISO_FORMAT)
                    .registerTypeAdapter(new TypeToken<ResultList<ProcessDefinitionRepresentation>>()
                    {
                    }.getType(), new ResultListDeserializer<>(ProcessDefinitionRepresentation.class));
        }
    }
}
