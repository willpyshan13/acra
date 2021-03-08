/*
 * Copyright (c) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package org.acra.http

import android.content.Context
import org.acra.ACRAConstants
import org.acra.config.CoreConfiguration
import org.acra.sender.HttpSender
import java.io.IOException
import java.io.OutputStream

/**
 * @author F43nd1r
 * @since 10.03.2017
 */
class DefaultHttpRequest(config: CoreConfiguration, context: Context, method: HttpSender.Method, private val contentType: String,
                         login: String?, password: String?, connectionTimeOut: Int, socketTimeOut: Int, headers: Map<String, String>?) :
        BaseHttpRequest<String>(config, context, method, login, password, connectionTimeOut, socketTimeOut, headers) {
    override fun getContentType(context: Context, t: String): String {
        return contentType
    }

    @Throws(IOException::class)
    override fun write(outputStream: OutputStream, content: String) {
        outputStream.write(content.toByteArray(Charsets.UTF_8))
    }
}