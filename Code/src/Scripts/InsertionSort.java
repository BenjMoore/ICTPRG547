package Scripts;

import java.util.ArrayList;

public class InsertionSort
{
    public static void InsertionSort(ArrayList<Object[]> dataValues) {
        int l;

        for (int i=0; i < dataValues.size() - 1; i++)
        {
            l = 0;
            for (int j=l + 1; j < dataValues.size() - i; j++)
            {
                if ((dataValues.get(l)[2]).toString().compareTo(String.valueOf(dataValues.get (j)[2])) < 0)
                {
                    l = j;
                }
            }
            Object [] temp = dataValues.get(dataValues.size() - 1 - i);
            dataValues.set (dataValues.size() - 1 - i, dataValues.get (l));
            dataValues.set (l, temp);
        }
    }
}
