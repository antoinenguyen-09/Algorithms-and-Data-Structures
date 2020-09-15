#include <iostream>
using namespace std;

int main ()
{
	long long int x,y,mod,result=1;
	cin >> x >> y >> mod;
	
	/* Trong đó: 
	+ x: phần cơ số của số bị chia lấy dư;
	+ y: phần số mũ của số bị chia lấy dư;
	+ mod: số chia lấy dư;
	*/
	x = x%mod;
	while (y > 0) {
		if (y%2) 
			result = (result*x)%mod;
		y = y/2;
		x = (x*x)%mod; 
	}
	cout<<result<<endl;
	return 0;
}
