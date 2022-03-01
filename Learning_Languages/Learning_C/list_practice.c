#include <stdio.h>
#include <stdlib.h>
#include"basiclist.h"
 
typedef struct {
  int x;
  int y;
} point_t;
 
int main(void) {
  node_t * list = NULL;
  node_t * curr;
 
  point_t p1 = {-1, 3};
  point_t p2 = {0, 4};
  point_t * p3 = (point_t *) malloc(sizeof(point_t));
  p3->x = -5;
  p3->y = 3;
  point_t * p4 = (point_t *) malloc(sizeof(point_t));
  p4->x = -2;
  p4->y = 7;
 
  list_add(&list, &p1);
  list_add(&list, &p2);
  list_add(&list, p3);
  list_add(&list, p4);
 
  curr = list;
 
  printf("Points:\n");
  while (curr != NULL) {
	point_t * this_point = (point_t *) curr->data;
	printf("  (%d, %d)\n", this_point->x, this_point->y);
	curr = curr->next;
  }
  return 0;
}
