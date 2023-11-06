///תחילה אנחנו מיבאים את שתי סיפריות שעוזרות לנו עם רשימות ומספרים

import java.util.ArrayList;
import java.util.List;

/// מגדירים קלאס שאומר למחשב איך לבצע משימות מסיומות
public class NumberDecomposition {
    ///זאת פונקציה שלוקחת מספר כמשתנה שתיצור רשימה שתוכל להחזיק רשימה אחרת של מספרים
    public static List<List<List<Integer>>> decomposeNumber(int num) {
        List<List<List<Integer>>> result = new ArrayList<>();

        ///אנחנו מתחילים עכשיו לולאה שממשיכה כול עוד משהו קורה,אנחנו משתשמים במספר של דיוואסור שמתחיל ב2 
        //וממשיכים כול עוד המספר גדול מ1
        
        for (int divisor = 2; num > 1; divisor++) {
            ///בתוך התהליך שלנו אנחנו יוצרים שתי קופסות ריקות שמחזיקות מספרים, קאונט זה מספר מיוחד שמתחיל ב0
            List<Integer> kValues = new ArrayList<>();
            int count = 0;

            ///כן אנחנו נכנסים ללואה כול עוד המספר שלנו יכול להיות מחולק על דיוואסור כלומר 2
            while (num % divisor == 0) {
                ///בתוך הלופ שלנו אנחנו מוסיפים את הדוואסור לתוך הקופסה שלנו ואז משנים את המספר שלנו על ידי חילוק עם דיוואסור
                ///וסופרים כמה פעמים זה קרה
                kValues.add(divisor);
                num /= divisor;
                count++;
            }
            ///אחריי הלופ אם חילקנו יותר מפעם אחת אנחנו מוסיפים לרשימה
            if (count > 1) {
                while (count > 1) {
                    kValues.add(divisor);
                    count--;
                }
            }
            ///אם הקופסה לא ריקה אנחנו מוסיפים את זה לקופסה של התוצאה
            if (!kValues.isEmpty()) {
                result.add(List.of(kValues));
            }
        }
        ///אחרי התהליך שלנו אם יש עדיין מספר גדול יותר מ1 אנחנו מוסיפים אותו לקופסה
        if (num > 1) {
            result.add(List.of(List.of(num)));
        }
        ///בסיום הליך הכולל שלנו אנחנו מחזירים את התוצאה
        return result;
    }
    ///עכשיו יש לנו עוד תהליך שנקרא מיין זה סוג של הדבר מרכזי,אנחנו מתחילים עם מספר ורוצה לפרק אותו
    public static void main(String[] args) {
        int num = 8330475;
        List<List<List<Integer>>> decompositions = decomposeNumber(num);
        /// אנחנו עוברים אחריי כול רשימה באוסף שלנו של הפונקציה הזאת שעשתה
        
        for (List<List<Integer>> decomposition : decompositions) {
            ///מציגים את האוסף מספרים על המסך
            System.out.println("Decomposition: " + decomposition);
        }
    }
}
