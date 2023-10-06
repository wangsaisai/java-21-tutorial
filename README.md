# java 21 新特性学习

- 顺序集合 SequencedCollection, SequencedSet, SequencedMap
- Virtual Thread
- 未命名模式和变量 （Unnamed Patterns and Variables）
- 记录类型的模式（Record Patterns）
- switch 的模式匹配（Pattern Matching for switch）
- 字符串模板 （String Templates）
- 结构化并发 Structured Concurrency (Preview)
- Scoped Value (Preview) - 进程间共享不可变对象

# 其他版本引入的新特性
- 文本块（Text Blocks）
- sealed class - 密封类，指定子类名，不允许再额外新增子类
- Records - 数据类。包括构造器、equals()、hashCode()和toString()等方法。 - 为了简化代码
- UTF-8 - Java 18中将UTF-8指定为标准Java API的默认字符集。这一更改的主要目标是使依赖于默认字符集的API更具可预测性和可移植性。 在Java 18之前，默认字符集是在Java运行时确定的，不同操作系统或环境下，结果不一样。