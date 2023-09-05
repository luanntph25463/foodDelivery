@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.fooddelivery

import android.media.Image
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.ui.theme.FoodDeliveryTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Header()
                }
            }
        }
    }
}

@Composable
fun find_food(){
    var find by rememberSaveable { mutableStateOf("") }
    Row(
        Modifier
            .padding(16.dp)
            .height(48.dp),
        // gắn cho nó ở giữa màn hình theo chiều dọc và ngang
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = find,
            onValueChange = { find = it },
            label = { Text(text = "Search Food, Vegetable, etc.", fontSize = 12.sp) },
            // singleLine chỉ hiển thị chữ trên 1 dòng
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            // bo tròn
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(1F)
        )
        IconButton(onClick = {}) {
            // gắn chữ bằng tint = white
            Icon(
                imageVector = Icons.Rounded.ShoppingCart, contentDescription = "",
                tint = Color.White
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Rounded.FavoriteBorder, contentDescription = "",
                tint = Color.White
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Rounded.Notifications, contentDescription = "",
                tint = Color.White
            )
        }
    }
}

@Composable
fun banner(modifier: Modifier) {
    Image(
        modifier = Modifier
            // fill max màn hình
            .fillMaxWidth()
            // kéo ảnh lên phía trên
            .offset(0.dp, (-30).dp),
        painter = painterResource(id = R.drawable.bg_main),
        contentDescription = "Header Background",
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun Header(modifer: Modifier = Modifier) {
    // dựng 1 box
    Box(Modifier.verticalScroll(rememberScrollState())) {
        // gắn background
        banner(modifier = Modifier)
        // phải xác định chiều dài và rộng cho row
        // tạo 1 column to
        Column() {
            find_food()
            list()
            space()
            LazyRow() {
                item {
                    card(
                        imagePainter = painterResource(id = R.drawable.promotion),
                        title = "Meat",
                        subtitle = "Discount",
                        header = "20%",
                        modifier = Modifier,
                    )
                }
                item {
                    card(
                        imagePainter = painterResource(id = R.drawable.promotion),
                        title = "Meat",
                        subtitle = "Discount",
                        header = "20%",
                        modifier = Modifier,
                    )
                }
            }
            space()
            body(modifier = Modifier)
        }
    }
}

@Composable
fun list(){
    Card(
        onClick = {},
        Modifier
            .height(64.dp)
            .padding(horizontal = 20.dp),
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {},
                Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_scan),
                    contentDescription = "Search", modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(32.dp)
                    .background(Color.Red)
            )
            Row(
                Modifier
                    .fillMaxHeight()
                    .weight(1F)
            ) {
                IconButton(
                    onClick = {},
                    Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_money),
                        tint = Color.Green,
                        contentDescription = "Search", modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                }
                Column(Modifier.padding(8.dp)) {
                    Text(text = "$120")
                    Text(text = "up")
                }
            }
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(32.dp)
                    .background(Color.Red)
            )
            Row(
                Modifier
                    .fillMaxHeight()
                    .weight(1F)
            ) {
                IconButton(
                    onClick = {},
                    Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coin),
                        tint = Color.Yellow,
                        contentDescription = "Search", modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                }
                Column(Modifier.padding(8.dp)) {
                    Text(text = "$10")
                    Text(text = "Points")
                }
            }
        }
    }
}

@Composable
fun card(modifier: Modifier,
         title: String = "",
         subtitle: String = "",
         header: String = "",
         imagePainter: Painter
) {
    Card(
        Modifier
            .padding(horizontal = 16.dp)
            .width(300.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            Modifier
                .padding()
        ) {
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun space(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
fun body(modifier: Modifier) {
    HomeSection(title = R.string.app_name) {
        AlignYourBodyRow()
    }
    HomeSection(title = R.string.app_name) {
        AlignYourBodyRowsellerItem()
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}
private val alignYourBodyData = listOf(
    R.drawable.ic_cheese to R.string.app_name,
    R.drawable.ic_meat to R.string.app_name,
    R.drawable.ic_orange to R.string.app_name,
    R.drawable.ic_veg to R.string.app_name,
).map { DrawableStringPair(it.first, it.second) }

private val alignYourBodyDataSeller = listOf(
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name)
).map { (drawableTextPair, sellerRes) ->
    val (drawableRes, textRes) = drawableTextPair
    DrawableStringPairSeller(drawableRes, textRes, sellerRes)
}

private val alignData = listOf(
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.item_apple, R.string.app_name), R.string.app_name)
).map { (drawableTextPair, sellerRes) ->
    val (drawableRes, textRes) = drawableTextPair
    DrawableStringPairSeller(drawableRes, textRes, sellerRes)
}



private data class DrawableStringPairSeller(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
    @StringRes val seller: Int
)
private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
@Composable
fun AlignYourBodyRowsellerItem(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyDataSeller) { item ->
            AlignYourBodyElementSeller(item.drawable, item.text, item.seller)
        }
    }
}

@Composable
//  khởi tạo phần tử alignYourBodyElement
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,

    modifier: Modifier = Modifier
) {
    // gắn     horizontalAlignment = Alignment.CenterHorizontally vào giữa
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_meat),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 24.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }

}


@Composable
//  khởi tạo phần tử alignYourBodyElement
fun AlignYourBodyElementSeller(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @StringRes seller: Int,
    modifier: Modifier = Modifier
) {
    // gắn     horizontalAlignment = Alignment.CenterHorizontally vào giữa
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.item_apple),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier.paddingFromBaseline(top = 24.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Row {
                Text(
                    "300",
                    textDecoration = if (1 > 0)
                        TextDecoration.LineThrough
                    else
                        TextDecoration.None,
                    color = if (1 > 0) Color.Gray else Color.Black
                )
                if (1 > 0) {
                    Text(text = "[$1%]", color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }

}


@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    // để trống và truyền vào 1 composable vào
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp)
            )
            TextButton(onClick = {}) {
                Text(
                    text = "More",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        }

        // truyền cục kahcs vào
        content()
    }
}

@Composable
// tạo 1 thanh bottomNavigation
fun ScootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "home"
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Profile"
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun FoodApp(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { ScootheBottomNavigation() }
    ) { padding ->
        Header(Modifier.padding(top = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryTheme {
        FoodApp()
    }
}