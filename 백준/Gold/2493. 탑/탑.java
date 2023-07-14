import java.io.*;
import java.util.*;

public class Main {

    static class Tower {
        int idx;
        int height;
        Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int height = Integer.parseInt(st.nextToken());
            if(i==1) {
                stack.push(new Tower(i, height));
                sb.append("0").append(" ");
            }
            else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0").append(" ");
                        stack.push(new Tower(i, height));
                        break;
                    }

                    Tower stackTower = stack.peek();
                    if (stackTower.height < height) {
                        stack.pop();
                    } else  {
                        stack.push(new Tower(i, height));
                        sb.append(stackTower.idx).append(" ");
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}

/*
// 3 9 7 5 8

// 3이 들어왔다. ( 제일 처음은 0, stack.push() )
// 9가 들어왔다. ( stack.peek()이 9보다 작다 -> stack.pop() )
// stack이 비었다. ( sb.append("0") stack.push() )
// 7이 들어왔다. ( stack.peek()이 7보다 크다. -> stack.push() -> sb.append() )
 */
