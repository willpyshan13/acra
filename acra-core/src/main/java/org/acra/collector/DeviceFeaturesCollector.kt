/*
 *  Copyright 2010 Kevin Gaudin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.acra.collector

import android.content.Context
import com.google.auto.service.AutoService
import org.acra.ReportField
import org.acra.builder.ReportBuilder
import org.acra.config.CoreConfiguration
import org.acra.data.CrashReportData
import org.json.JSONException
import org.json.JSONObject

/**
 * Collects features declared as available on the device.
 *
 * @author Kevin Gaudin &amp; F43nd1r
 */
@AutoService(Collector::class)
class DeviceFeaturesCollector : BaseReportFieldCollector(ReportField.DEVICE_FEATURES) {
    @Throws(JSONException::class)
    override fun collect(reportField: ReportField, context: Context, config: CoreConfiguration, reportBuilder: ReportBuilder, target: CrashReportData) {
        val result = JSONObject()
        val pm = context.packageManager
        val features = pm.systemAvailableFeatures
        for (feature in features) {
            val featureName = feature.name
            if (featureName != null) {
                result.put(featureName, true)
            } else {
                result.put("glEsVersion", feature.glEsVersion)
            }
        }
        target.put(ReportField.DEVICE_FEATURES, result)
    }
}