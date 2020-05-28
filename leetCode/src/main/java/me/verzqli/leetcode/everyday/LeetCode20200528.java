package me.verzqli.leetcode.everyday;

public class LeetCode20200528 {
    public static void main(String[] args) {
        System.out.printf("��ά��" + (new LeetCode20200528().decodeString("3[a]2[bc]e")));
    }

    private int curIndex;
    public String decodeString(String s) {
        return helper(s, 0);
    }

    public String helper(String data,int start){

        StringBuilder res=new StringBuilder();
        int repeat=0;
        while (start<data.length()){
            char ch=data.charAt(start);
            if (ch>='0'&&ch<='9')
                //����Ϊ�˴���repeat����Ϊ��ʮ�ϰٴε��������Ϊһ��ֻ��һ���ַ�
                repeat=repeat*10+ch-'0';
            else if (ch=='['){//�ݹ鿪ʼ
                String item=helper(data,start+1);
                while (repeat>0) {
                    res.append(item);
                    repeat--;
                }
                //�������curIndex�±�û�д���ã�
                start=curIndex;
            }else if (ch==']'){
                curIndex=start;
                return res.toString();
            }else {
                res.append(data.charAt(start));
            }
            ++start;
        }
        return res.toString();
    }
}
