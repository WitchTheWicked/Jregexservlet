function [x y]=cluster()
N=pois(6);
x=rand(N,1);
y=rand(N,1);

ox=zeros(2,1);
oy=zeros(2,1);

j=0;

for i=1:N
   M=pois(10);
   for k=1:M
       j=j+1;
       ox(j)=x(i)+randn()*.01;
       oy(j)=y(i)+randn()*.01;
   end
end

hold on
plot(x,y,'o');
plot(ox,oy,'rs');

drawnow;
    
end

function p=pois(S);

if(S<=100)
temp=-S;
L=exp(temp);
k=0;
p=1; 
while(p > L)
k=k+1;
p=p*rand();
end
p=k-1;
else
p=floor(S+S^.5*randn());
end
end
