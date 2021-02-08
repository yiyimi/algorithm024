# 学习笔记

## Tree

- 二叉树遍历方式：
  - 先序遍历：root->left->right
  - 中序遍历：left->root->right
  - 后序遍历：left->right->root

- Unicode 是为了解决传统字符编码的局限性而产生的方案，它为每个语言中的字符规定了一个唯一的二进制编码。
- Unicode 中可能存在一个字符对应多个字节的问题，为了让计算机知道多少字节表示一个字符，面向传输的编码方式的UTF−8 和UTF−16 也随之诞生逐渐广泛使用。

## HashMap

- 利用数组按下标随机访问数据实现；
- 散列表/哈希表/Hash Table
  - key/hash function/table

### Java 11 HashMap

- 初始容量16，装载因子loadFactor默认0.75F;
- 用链表实现冲突解决；
  - 插入方法putVal()中，当HashMap.Node长度大于8，则转换为HashMap.TreeNode;
  - remove类似，代码待细看;
  ```

  ```Java
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        HashMap.Node[] tab;
        int n;
        if ((tab = this.table) == null || (n = tab.length) == 0) {
            n = (tab = this.resize()).length;
        }

        Object p;
        int i;
        if ((p = tab[i = n - 1 & hash]) == null) {
            tab[i] = this.newNode(hash, key, value, (HashMap.Node)null);
        } else {
            Object e;
            Object k;
            if (((HashMap.Node)p).hash == hash && ((k = ((HashMap.Node)p).key) == key || key != null && key.equals(k))) {
                e = p;
            } else if (p instanceof HashMap.TreeNode) {
                e = ((HashMap.TreeNode)p).putTreeVal(this, tab, hash, key, value);
            } else {
                int binCount = 0;

                while(true) {
                    if ((e = ((HashMap.Node)p).next) == null) {
                        ((HashMap.Node)p).next = this.newNode(hash, key, value, (HashMap.Node)null);
                        if (binCount >= 7) {
                            this.treeifyBin(tab, hash);
                        }
                        break;
                    }

                    if (((HashMap.Node)e).hash == hash && ((k = ((HashMap.Node)e).key) == key || key != null && key.equals(k))) {
                        break;
                    }

                    p = e;
                    ++binCount;
                }
            }

            if (e != null) {
                V oldValue = ((HashMap.Node)e).value;
                if (!onlyIfAbsent || oldValue == null) {
                    ((HashMap.Node)e).value = value;
                }

                this.afterNodeAccess((HashMap.Node)e);
                return oldValue;
            }
        }

        ++this.modCount;
        if (++this.size > this.threshold) {
            this.resize();
        }

        this.afterNodeInsertion(evict);
        return null;
    }

  ```

- 散列函数：
  - 获取当前对象key的hashCode后再运算；

  ```Java
    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }

