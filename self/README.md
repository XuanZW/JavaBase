# Thinking In Java 一些记录

## 容器
### 两大分类
Java容器类库中的两种主要类型，区别在于容器中每个“槽”保存的元素个数。
* Collection: 在每个槽中只保存一个元素
    * List: (列表)以特定的顺序保持一组元素
		* ArrayList: 使用数组实现，随机访问较快，在中间插入和删除元素时较慢
		* LinkedList: 使用链表实现，顺序访问较快，在中间插入和删除元素代价较低
    * Set(集合): 元素不能重复
		* HashSet: 最快的获取速度(哈希表)
		* TreeSet: 存储顺序很重要(红黑树)，可用于排序(SortSet)
		* LinkedHashSet: 按照被添加的顺序保存对象(链表-哈希表)
    * Queue(队列): 只允许在容器的一端插入对象，并从另一端移除对象
		* PriorityQueue: 优先队列
* Map(关联数组): 在每个槽内保存两个对象，键和关联值
    * HashMap: 提供最快的查找技术
    * TreeMap: 按照比较结果的升序保存键
    * LinkedHashMap: 按照插入顺序保存键，同时保留HashMap的查询速度



