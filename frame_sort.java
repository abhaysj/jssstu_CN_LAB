import java.util.Scanner;

class Frames {
    int frameno;
    String data;
}


class Framesort{
    /**
     * @param args
     */
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enter the number of frames ");
            int n=sc.nextInt();
            Frames frame[] = new Frames[n];
            //taking input for each frame
            System.out.println("enter the data of each frame ");
            for(int i=0;i<n;i++){
                frame[i]=new Frames();
                System.out.println("enter the frame no");
                frame[i].frameno=sc.nextInt();
                System.out.println("enter the data");
                frame[i].data= sc.next();
            }
            //sorting the frames
            int swapped=0;
            Frames temp = new Frames();
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-i-1;j++){
                    if(frame[j].frameno>frame[j+1].frameno){
                        swapped=1;
                        temp=frame[j];
                        frame[j]=frame[j+1];
                        frame[j+1]=temp;
                    }
                }
                if(swapped==0){
                    break;
                }
            }
            System.out.println("the sorted frames are ");
            System.out.println("frame no  data");
            for(Frames f: frame){
                
                System.out.println(f.frameno+"\t  "+f.data+" ");
                //System.out.println("");
            }
        }
    }
}



