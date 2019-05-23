## logback: 自定义 MessageConverter 实现日志参数统一处理

自定义 MessageConverter 实现日志参数统一处理, 例如:

1. 自动过滤参数中的敏感信息;
2. 自动为参数调用对象转 JSON 的方法, 避免当对象没有实现 `toString()` 方法时无法记录有效信息的问题;
3. ...



注意:

1. 必须将对应的 `conversionRule` 配置放在 `logback-spring.xml` 的考前位置, 否则 logback 会生成不生效;
2. `conversionRule.conversionWord` 必须与 `encoder.pattern` 中希望处理的字段完全一致, 比如在 logback 中 `%m`, `%msg`, `%message` 都可以输出日志, 但如果在 `encoder.pattern` 中使用了 `%m`, 则 `conversionRule.conversionWord` 也必须是 `m`.