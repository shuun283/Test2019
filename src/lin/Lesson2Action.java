package lin;

public class Lesson2Action {
    //    /**
    //     * 冒泡排序・昇順排列
    //     * バブルソート・数字の昇順并べ
    //     * @param args
    //     */
    //    public static void main(String[] args){
    //        int iTmp = 0;
    //        int[] targetArr = {123,12,45,65,21,2,79,46,63,22};
    //        for(int i=8;i>=0;i--){
    //            for(int j=0;j<=i;j++){
    //                if(targetArr[j]>targetArr[j+1]){
    //                    iTmp = targetArr[j+1];
    //                    targetArr[j+1] = targetArr[j];
    //                    targetArr[j] = iTmp;
    //                }
    //            }
    //        }
    //        for(int i=0;i<10;i++){
    //            System.out.println(targetArr[i]);
    //        }
    //    }
    /**
     * 加算機
     * <pre>
     * "\"⇒"\\\\"
     * "+"⇒"\\+"
     ＊"＊"⇒"\\*"
     * "."⇒"\\."
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        String targetStr = "00999+12";
        String[] numArr = targetStr.split("\\+");
        int result = Integer.parseInt(numArr[0]) + Integer.parseInt(numArr[1]);
        System.out.println(result);
    }
}