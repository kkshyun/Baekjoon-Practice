#include<stdio.h>
#include<stdlib.h>

int main() {
    int size, max, temp;
    double sum = 0;
    scanf("%d",&size);
    double *arr = (double*)malloc(sizeof(double)*size);
    for(int i=0;i<size;i++) {
        scanf("%lf",&arr[i]);
    }

    for(int i=0;i<size;i++) {
        for(int j=0;j<size-1-i;j++) {
            if(arr[j]>arr[j+1]) {
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
   
   max = arr[size-1];
   for(int i=0;i<size;i++) {
        sum += arr[i]/max*100;
    }
    printf("%f",sum/size);
}