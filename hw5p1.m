function hw5p1()
N = 50;
X = rand(N,2);
A = zeros(N,N);

%create the 10 nodes with 5 connections
for i = 1:10,
    connections = 0;
    while(connections < 5)
        u = ceil(rand() * i);
        A(i,u) = 1;
        A(u,i) = 1;
        connections = connections + 1;
    end
end
%put in the rest of the connections here
for i = 11:50,
    j = 0;
   while(j < 5)
       u = ceil( 50 * rand() );
       if(u <= 10)
           prob = ( sum( A ( i,: ) )/ sum( sum( A ) ) );
           if(rand () < prob)
               A(i,u) = 1;
               A(u,i) = 1;
           else
               j = j - 1;
           end
       else
           A(i,u) = 1;
           A(u,i) = 1;
           j = j + 1;
       end
gplot(A, X, 'o-');   
drawnow;
end

%display the page rankings
for i = 1:N,
    AA = sum(A(i, :));
    if(AA == 0)
        M(i,:) = ones(1,N)/N;
    else
        M(i,:) = A(i,:) / AA;
    end
end

delta = 0.85;

R1 = inv((eye(N) - (delta * M'))) * ((1-delta)/N) * ones(N,1);
for i = 1:N,
    R2(i) = sum(A(i,:));
end
sum_R2 = sum(R2);
for i = 1:N,
    ranking_R2(i) = R2(i) / sum_R2;
end
end


hist(sum(A));
ranking_R2;