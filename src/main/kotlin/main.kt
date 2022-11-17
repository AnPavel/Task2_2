data class Post constructor(
    var id: Int,
    val fromId: Int,
    val createdBy: Int,
    val published: Long,
    val text: String,
    val comments: String,
    val likes: Int,
    val canDelete: Boolean,
    val canEdit: Boolean
)

object WallService {

    private var posts = emptyArray<Post>()
    private var idPosts: Int = 1

    fun clear() {
        posts = emptyArray()
    }

    //�������� ����
    fun add(post: Post): Post {
        for ((index, post) in posts.withIndex()) {
            if (post.id == idPosts) {
                idPosts += 1
              }
        }
        post.id = idPosts
        posts += post
        //println("��������� " + posts.last())

        //val totalRecords = posts.size
        //println("����� ������� $totalRecords")
        return posts.last()
    }


    fun update(post: Post): Boolean {
        var (id) = post
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(text = "update text", comments = "update comment", likes = post.likes + 100, canDelete = false, canEdit = false)
                println(posts[index])
                return true
            }
        }
        return false
    }


    fun idById(id: Int) {
        //������� �� ���� ����� ����� ������
        //��� ���� �������� ������
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                println("������ ��������� ��� id = " + post.id)
                posts[index] = post.copy(text = "update text update", comments = "update comment update", likes = post.likes + 10, canDelete = false, canEdit = false)
                //println("the element at $index is  $post")
            }
        }
    }
}


fun main() {

    val post = Post(0,11, 99, 20221010,"text post 0", "comment content", 0, true,true)
    //val (id, fromId, _, published, text, content, likes) = post
    //println("$id, $fromId, $published, $text, $content, $likes")
    var result = WallService.add(post)
    //println(result)

    //����� �������
    val postOne = post.copy(fromId = 12, text = "text post 1", likes = post.likes + 1)
    result = WallService.add(postOne)
    //println(result)
    val postTwo = post.copy(fromId = 13, text = "text post 2", likes = post.likes + 2)
    result = WallService.add(postTwo)
    //println(result)

    //������� ����� ��������� ���� �� id
    //WallService.idById(postOne.id)
    println("--------")
    println( WallService.update(postOne))

}