Other way of finding intersection of 2 lists, compared to previous Hash collision method.

The approach is sorting the shorter list ( O(n logn) time complexity). 
This allows the use of binary search for comparisons with longer list of size m ( which makes m binary searches ( of O(log n) pesimistic time complexity).

To sum up pesimistic time complexity is O( nlogn + mlogn) which is O ( (n+m)logn ) which is much better than O(n^2) (naive comparison method) for huge sets.
