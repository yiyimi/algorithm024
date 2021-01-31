package algo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 * @Author: yiyimi
 * @Date: 2021/1/31 0031
 */
public class DequeDemo {
/**push output:
 [c, b, a]
 c
 [c, b, a]
 c
 b
 a
 []
 */
/** addFirst output:
 [c, b, a]
 c
 [c, b, a]
 c
 b
 a
 []
 */
/** addLast output:
 [a, b, c]
 a
 [a, b, c]
 a
 b
 c
 []
 */

    public void addFirst() {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    public void addLast() {
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    public void push() {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

}
