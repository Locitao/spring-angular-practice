import { Injectable } from '@angular/core';
import { Todo } from './todo';
import 'rxjs/add/operator/toPromise';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class TodoService {
  private baseUrl = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }

  getTodos(): Promise<Todo[]> {
    return this.httpClient.get<Todo[]>(this.baseUrl + '/api/todos')
      .toPromise()
      .catch(this.handleError);
  }

  createTodo(todoData: Todo): Promise<Todo> {
    return this.httpClient.post<Todo>(this.baseUrl + '/api/todos/', todoData)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
