/*
public class testC {

    int main()
    {
        int n,x,a[100009],b[100009],mina,mini,a2=-2,b2=-2;
        cin>>n>>x;
        int maxs = x;

        for (int i=0; i<n; i++)
            cin>>a[i];
        for (int i=0; i<n; i++)
            cin>>b[i];

        mina = a[0];
        mini = 0;

        for (int i=1; i<n; i++)
        {
            if ((x/mina)*b[i]>maxs)
            {
                maxs = (x/mina)*b[i];
                a2 = mini;
                b2 = i;
            }

            if (a[i]<mina)
            {
                mina = a[i];
                mini=i;
            }
        }

        cout<<maxs<<endl;
        cout<<a2+1<<" "<<b2+1;
        return 0;
    }

}
*/
