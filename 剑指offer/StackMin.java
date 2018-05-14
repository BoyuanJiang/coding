import java.util.Stack;

public class StackMin {
    private Stack<Integer> m_data=new Stack<>();
    private Stack<Integer> m_min=new Stack<>();

    public void push(int node) {
        if (m_min.isEmpty()) {
            m_min.push(node);
            m_data.push(node);
        }
        else if (top()<=node) {
            m_min.push(top());
            m_data.push(node);
        }
        else
        {
            m_min.push(node);
            m_data.push(node);
        }
    }

    public void pop() {
        m_data.pop();
        m_min.pop();
    }

    public int top() {
        return m_min.peek();
    }

    public int min() {
        return m_min.peek();
    }
}
