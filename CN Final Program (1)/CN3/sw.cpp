/****************Assignment No:3*****************************
Title :-Write a program to simulate go-back-n of sliding window protocol in peer to peer
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
***************************************************************/
#include<iostream>
using namespace std;

#include<stdlib.h>
#include<time.h>
#include<math.h>
#define TOT_FRAMES 500
#define FRAMES_SEND 10


class sel_repeat

{

private:

int fr_send_at_instance;

int arr[TOT_FRAMES];

int send[FRAMES_SEND];

int rcvd[FRAMES_SEND];

char rcvd_ack[FRAMES_SEND];

int sw;

int rw;       //tells expected frame

public:

void input();

void sender(int);

void receiver(int);

};

void sel_repeat::input()

{

int n;     //no. of bits for the frame

int m;    //no. of frames from n bits
int i;
cout<<"Enter the no. of bits for the sequence no. : ";

cin>>n;

m=pow(2,n);

int t=0;

fr_send_at_instance=(m/2);

for(i=0;i<TOT_FRAMES;i++)

{

arr[i]=t;

t=(t+1)%m;

}

for(i=0;i<fr_send_at_instance;i++)

{

send[i]=arr[i];

rcvd[i]=arr[i];

rcvd_ack[i]='n';

}

rw=sw=fr_send_at_instance;

sender(m);

}

void sel_repeat::sender(int m)

{

for(int i=0;i<fr_send_at_instance;i++)

{

if(rcvd_ack[i]=='n')

cout<<"SENDER : Frame "<<send[i]<<" is sent\n";

}

receiver(m);

}

void sel_repeat::receiver(int m)

{

time_t t;

int f;
int j;
int f1;

int a1;

char ch;

srand((unsigned)time(&t));

for(int i=0;i<fr_send_at_instance;i++)

{

if(rcvd_ack[i]=='n')

{

f=rand()%10;

//if f=5 frame is discarded for some reason

//else frame is correctly recieved

if(f!=5)

{

for(int j=0;j<fr_send_at_instance;j++)

if(rcvd[j]==send[i])

{

cout<<"reciever:Frame"<<rcvd[j]<<"recieved correctly\n";

rcvd[j]=arr[rw];

rw=(rw+1)%m;

break;

}
int j;
if(j==fr_send_at_instance)

cout<<"reciever:Duplicate frame"<<send[i]<<"discarded\n";

a1=rand()%5;

//if al==3 then ack is lost

//else recieved

if(a1==3)

{

cout<<"(acknowledgement "<<send[i]<<" lost)\n";

cout<<"(sender timeouts-->Resend the frame)\n";

rcvd_ack[i]='n';

}

else

{

cout<<"(acknowledgement "<<send[i]<<" recieved)\n";

rcvd_ack[i]='p';

}

}

else

{int ld=rand()%2;

//if =0 then frame damaged

//else frame lost

if(ld==0)

{

cout<<"RECEIVER : Frame "<<send[i]<<" is damaged\n";

cout<<"RECEIVER : Negative Acknowledgement "<<send[i]<<" sent\n";

}

else

{

cout<<"RECEIVER : Frame "<<send[i]<<" is lost\n";

cout<<"(SENDER TIMEOUTS-->RESEND THE FRAME)\n";

}

rcvd_ack[i]='n';

}

}

}

for(int j=0;j<fr_send_at_instance;j++)

{

if(rcvd_ack[j]=='n')

break;

}

int i=0;

for(int k=j;k<fr_send_at_instance;k++)

{

send[i]=send[k];

if(rcvd_ack[k]=='n')

rcvd_ack[i]='n';

else

rcvd_ack[i]='p';

i++;

}

if(i!=fr_send_at_instance)

{

for(int k=i;k<fr_send_at_instance;k++)

{

send[k]=arr[sw];

sw=(sw+1)%m;

rcvd_ack[k]='n';

}

}

cout<<"Want to continue";

cin>>ch;

cout<<"\n";

if(ch=='y')

sender(m);

else

exit(0);

}

int main()

{


sel_repeat sr;

sr.input();

//ducslectures.blogspot.in

}


/**** OUTPUT ****
administrator@siftworkstation:~/Desktop/PL4/B13$ g++ B13_sw.cpp -o B13_sw
administrator@siftworkstation:~/Desktop/PL4/B13$ ./B13_sw
Enter the no. of bits for the sequence no. : 4
SENDER : Frame 0 is sent
SENDER : Frame 1 is sent
SENDER : Frame 2 is sent
SENDER : Frame 3 is sent
SENDER : Frame 4 is sent
SENDER : Frame 5 is sent
SENDER : Frame 6 is sent
SENDER : Frame 7 is sent
reciever:Frame0recieved correctly
(acknowledgement 0 lost)
(sender timeouts-->Resend the frame)
reciever:Frame1recieved correctly
(acknowledgement 1 recieved)
reciever:Frame2recieved correctly
(acknowledgement 2 recieved)
RECEIVER : Frame 3 is damaged
RECEIVER : Negative Acknowledgement 3 sent
reciever:Frame4recieved correctly
(acknowledgement 4 recieved)
reciever:Frame5recieved correctly
(acknowledgement 5 recieved)
reciever:Frame6recieved correctly
(acknowledgement 6 lost)
(sender timeouts-->Resend the frame)
reciever:Frame7recieved correctly
(acknowledgement 7 recieved)
Want to continuey

SENDER : Frame 0 is sent
SENDER : Frame 3 is sent
SENDER : Frame 6 is sent
(acknowledgement 0 recieved)
reciever:Frame3recieved correctly
(acknowledgement 3 recieved)
(acknowledgement 6 recieved)
Want to continuey

Want to continue0

administrator@siftworkstation:~/Desktop/PL4/B13$ 


*/
