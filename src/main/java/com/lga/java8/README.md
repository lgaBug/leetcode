


# stream
> 对集合迭代器的增强，能够高效的完成聚合操作（过滤、排序、分组统计），并且stream与lambda表达式结合后的编码效率大大提高，可读性更强。
> 
> 

# lambda表达式详解

## 中间节点
> 返回的是stream
- filter 过滤
- map 转换
- peek 啥也不做，类似foreach


## 终止节点
>返回的不是stream
>
- toArray
- collect

