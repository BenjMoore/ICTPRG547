package Scripts;

import java.util.ArrayList;

public class BubbleSort
{
    public static void bubbleSort(ArrayList<Object[]> arr)
    {
        for(int j=0; j<arr.size(); j++)
        {
            for(int i=j+1; i<arr.size(); i++)
            {
                if((arr.get(i)[1]).toString().compareToIgnoreCase(arr.get(j)[1].toString())<0)
                {
                    Object[] words = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, words);
                }
            }
        }
    }
}
