package com.example.logbackMessageConverter

import ch.qos.logback.classic.pattern.MessageConverter
import ch.qos.logback.classic.spi.ILoggingEvent
import com.alibaba.fastjson.JSON
import org.slf4j.helpers.MessageFormatter

/**
 * @author zhixiao.mzx
 * @date 2019-05-14
 */
class LogbackArg2JsonConverter : MessageConverter() {
    override fun convert(event: ILoggingEvent?): String {
        if (null == event) {
            return super.convert(event)
        }

        return try {
            MessageFormatter.arrayFormat(
                event.message,
                event.argumentArray.map { JSON.toJSONString(it) }.toTypedArray()
            ).message
        } catch (e: Exception) {
            super.convert(event)
        }
    }
}
